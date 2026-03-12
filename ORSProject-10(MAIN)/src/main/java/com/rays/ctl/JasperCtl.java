package com.rays.ctl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.MarksheetDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping(value = "Jasper")
public class JasperCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

    @PersistenceContext
    protected EntityManager entityManager;

    @GetMapping(value = "report", produces = { MediaType.APPLICATION_PDF_VALUE })
    public void display(HttpServletResponse response) throws JRException, IOException {

        Connection con = null;

        // JRXML classpath se load hoga
		InputStream reportStream = getClass().getClassLoader()
                .getResourceAsStream("reports/project10.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        Map<String, Object> map = new HashMap<>();

        Session session = (Session) entityManager.unwrap(Session.class);
        con = ((SessionImpl) session).connection();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);

        byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

        response.setContentType("application/pdf");
        response.getOutputStream().write(pdf);
        response.getOutputStream().flush();

        System.out.println("Report Generated Successfully...");
    }
}
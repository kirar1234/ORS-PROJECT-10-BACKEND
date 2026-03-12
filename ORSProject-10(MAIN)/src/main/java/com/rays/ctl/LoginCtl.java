package com.rays.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.config.JWTUtil;
import com.rays.dto.UserDTO;
import com.rays.form.ForgetPasswordForm;
import com.rays.form.LoginForm;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;

/**
 * LoginCtl is a REST Controller used for authentication operations.
 * 
 * It handles: - User Login - User Registration (SignUp) - User Logout
 * 
 * Base URL: /Auth
 * 
 * @author Amit
 */
@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserServiceInt userService;
	/**
	 * Login API
	 * 
	 * This method authenticates the user using loginId and password. If credentials
	 * are valid, user information is stored in HTTP session.
	 * 
	 * URL: POST /Auth/login
	 * 
	 * @param form          LoginForm containing loginId and password
	 * @param bindingResult validation result
	 * @param session       HTTP session
	 * @param request       HTTP request
	 * @return ORSResponse containing login status and user details
	 */
	@PostMapping("login")
	public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindingResult, HttpSession session,
			HttpServletRequest request) throws Exception {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.authenticate(form.getLoginId(), form.getPassword());

		if (dto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid Login ID & Password");
		} else {
			UserContext context = new UserContext(dto);

			

			final String token = jwtUtil.generateToken(dto.getId(), dto.getLoginId(), dto.getRoleName());
			
			res.setSuccess(true);
			res.addData(dto);
			res.addResult("loginId", dto.getLoginId());
			res.addResult("role", dto.getRoleName());
			res.addResult("fname", dto.getFirstName());
			res.addResult("lname", dto.getLastName());
			 res.addResult("token", token);
			return res;
		}
		return res;
	}

	/**
	 * User Registration API
	 * 
	 * This method registers a new user in the system. It first checks whether
	 * loginId already exists or not.
	 * 
	 * URL: POST /Auth/signUp
	 * 
	 * @param form          UserRegistrationForm containing user details
	 * @param bindingResult validation result
	 * @return ORSResponse with registration status
	 */
	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.findByLoginId(form.getLoginId(), userContext);

		if (dto != null) {
			res.setSuccess(false);
			res.addMessage("Login Id already exists");
			return res;
		}

		dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		dto.setDob(form.getDob());
		dto.setGender(form.getGender());
		dto.setPhone(form.getPhone());

		dto.setStatus("Inactive");
		dto.setRoleId(2L);

		baseService.register(dto, userContext);

		res.setSuccess(true);
		res.addMessage("User has been registered successfully..!!");
		return res;
	}

	/**
	 * Logout API
	 * 
	 * This method destroys the user session and logs the user out.
	 * 
	 * URL: GET /Auth/logout
	 * 
	 * @param session HTTP session
	 * @return ORSResponse with logout message
	 */

	@PostMapping("/forgotPassword")
	public ORSResponse changePassword(@RequestBody @Valid ForgetPasswordForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		boolean flag = userService.forgotPassword(form.getLoginId());

		if (flag == true) {
			res.setSuccess(true);
			res.addMessage("Password sent to your email");
		} else {
			res.setSuccess(false);
			res.addMessage("Login Id not found");
		}

		return res;

	}

	@GetMapping("logout")
	public ORSResponse logout(HttpSession session) throws Exception {

		ORSResponse res = new ORSResponse();

		session.invalidate();

		res.addMessage("Logout successfully..!!");

		return res;
	}

}
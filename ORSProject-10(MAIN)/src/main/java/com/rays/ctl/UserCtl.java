package com.rays.ctl;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.form.ChangePasswordForm;
import com.rays.form.MyProfileForm;
import com.rays.form.UserForm;
import com.rays.service.AttachmentServiceInt;
import com.rays.service.RoleServiceInt;
import com.rays.service.UserServiceInt;

/**
 * UserCtl is a REST Controller that manages User related operations.
 * 
 * It extends BaseCtl which provides common CRUD operations like: save, search,
 * deleteMany, get etc.
 * 
 * Additional features implemented in this controller: 1. Preload role list for
 * dropdown 2. Upload profile picture 3. Download profile picture
 * 
 * Base URL : /User
 * 
 * @author Amit
 */
@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

	@Autowired
	UserServiceInt userService;

	@Autowired
	private RoleServiceInt roleService;

	@Autowired
	AttachmentServiceInt attachmentService;

	/**
	 * Preload API
	 * 
	 * This method loads required dropdown data before opening the user form.
	 * Currently it loads Role list.
	 * 
	 * URL : GET /User/preload
	 * 
	 * @return ORSResponse containing roleList
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse resp = new ORSResponse(true);

		List<DropdownList> roleList = roleService.search(new RoleDTO(), userContext);

		resp.addResult("roleList", roleList);

		return resp;
	}

	@PostMapping("myProfile")
	public ORSResponse myProfile(@RequestBody @Valid MyProfileForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		System.out.println("userid" + userContext.getUserId());
		UserDTO dto = baseService.findById(userContext.getUserId(), userContext);
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setDob(form.getDob());
		dto.setPhone(form.getPhone());
		dto.setGender(form.getGender());

		baseService.update(dto, userContext);

		res.setSuccess(true);
		res.addMessage("Your Profile updated successfully..!!");

		return res;
	}

	@PostMapping("changePassword")
	public ORSResponse changePassword(@RequestBody @Valid ChangePasswordForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO changedDto = baseService.changePassword(form.getLoginId(), form.getOldPassword(), form.getNewPassword(),
				userContext);

		if (changedDto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid old password");
			return res;
		}

		res.setSuccess(true);
		res.addMessage("Password has been changed");

		return res;
	}

	/**
	 * Upload Profile Picture API
	 * 
	 * This method uploads a profile image for a user. If user already has an image
	 * then it updates the existing image.
	 * 
	 * URL : POST /User/profilePic/{userId}
	 * 
	 * @param userId User ID
	 * @param file   uploaded image file
	 * @param req    HttpServletRequest
	 * @return ORSResponse containing imageId
	 */
	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		AttachmentDTO attachmentDto = new AttachmentDTO(file);

		attachmentDto.setDescription("profile pic");

		attachmentDto.setUserId(userId);

		UserDTO userDto = userService.findById(userId, userContext);

		if (userDto.getImageId() != null && userDto.getImageId() > 0) {

			attachmentDto.setId(userDto.getImageId());

		}

		Long imageId = attachmentService.save(attachmentDto, userContext);

		if (userDto.getImageId() == null) {

			userDto.setImageId(imageId);

			userService.update(userDto, userContext);
		}

		ORSResponse res = new ORSResponse();

		res.addResult("imageId", imageId);

		res.setSuccess(true);

		return res;
	}

	/**
	 * Download Profile Picture API
	 * 
	 * This method returns the user's profile picture from database. Image is
	 * written directly to HTTP response output stream.
	 * 
	 * URL : GET /User/profilePic/{userId}
	 * 
	 * @param userId   User ID
	 * @param response HttpServletResponse
	 */
	@GetMapping("/profilePic/{userId}")
	
	public @ResponseBody void downloadPic(@PathVariable Long userId, HttpServletResponse response) {

		try {

			UserDTO userDto = userService.findById(userId, userContext);

			AttachmentDTO attachmentDTO = null;

			if (userDto != null) {
				attachmentDTO = attachmentService.findById(userDto.getImageId(), userContext);
			}

			if (attachmentDTO != null) {
				response.setContentType(attachmentDTO.getType());
				OutputStream out = response.getOutputStream();
				out.write(attachmentDTO.getDoc());
				out.close();
			} else {
				response.getWriter().write("ERROR: File not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
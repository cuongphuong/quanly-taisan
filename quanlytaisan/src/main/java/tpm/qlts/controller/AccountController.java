package tpm.qlts.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tpm.qlts.entitys.Users;
import tpm.qlts.services.UserRevice;


@Controller
@RestController
@RequestMapping("account")
public class AccountController {
	@Autowired
	private UserRevice userService;
	
	@PostMapping("check")
	public boolean checkLogin() {
		return true;
	}
	
	@GetMapping("/get-all-user")
	public List<Users> getAllUser() {
		List<Users> resLst = userService.findAll();
		for(Users u : resLst) {
			u.setPassword("encode with bcrypt.");
		}
		return resLst;
	}
	
	@GetMapping("get-info-user")
	public Users getInfoUser(Principal principal) {
		Users uRes = userService.findByUserName(principal.getName());
		uRes.setPassword("password is not response...");
		return uRes;
	}
	
//	public OutputAccount getInfoUser() {
//		
//	}
}

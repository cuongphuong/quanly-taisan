package tpm.qlts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
@RequestMapping("account")
public class AccountController {
	
	@PostMapping("check")
	public boolean checkLogin() {
		return true;
	}
	
//	public OutputAccount getInfoUser() {
//		
//	}
}

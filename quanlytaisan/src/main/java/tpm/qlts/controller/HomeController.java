package tpm.qlts.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/")
	public String index()
	{
		return "hello";
	}
}

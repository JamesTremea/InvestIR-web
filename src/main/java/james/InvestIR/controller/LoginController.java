package james.InvestIR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getPaginaLogin(){
		return "/auth/login";
	}

	@PostMapping("/login")
	public String getPaginaLogin(Model model, @ ){
		return "/layouts/home";
	}


}

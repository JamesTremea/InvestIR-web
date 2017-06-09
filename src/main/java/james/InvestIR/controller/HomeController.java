package james.InvestIR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String getHomePage(){
		return "/layouts/home";
	}

	@GetMapping("/carteira")
	public String getWalletPage(){
		return "/carteira/carteira";
	}

	@GetMapping("/notas")
	public String getNotesPage(){
		return "/notas/notas";
	}

	
}

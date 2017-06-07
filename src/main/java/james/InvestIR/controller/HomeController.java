package james.InvestIR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(){
		return "/layouts/home";
	}

	@GetMapping("/carteira")
	public String wallet(){
		return "/carteira/carteira";
	}

	@GetMapping("/notas")
	public String notes(){
		return "/notas/notas";
	}

}

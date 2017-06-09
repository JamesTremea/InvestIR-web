package james.InvestIR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarteiraController {

	@GetMapping("/carteiraInicial")
	public String initialWallet(){
		return "/carteira/carteiraInicial";
	}

}

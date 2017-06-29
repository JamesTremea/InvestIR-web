package james.InvestIR.controller;

import java.security.Principal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import james.InvestIR.config.Messages;
import james.InvestIR.domain.Carteira;
import james.InvestIR.domain.ImplUsuario;
import james.InvestIR.domain.Usuario;
import james.InvestIR.service.CarteiraService;
import james.InvestIR.service.UsuarioService;

/**
* created by james on 27/06/2017
*/

@Controller
public class HomeController {

	private final UsuarioService usuarioService;
	private final CarteiraService carteiraService;
	private final Messages messages;

	public HomeController(UsuarioService usuarioService, CarteiraService carteiraService, Messages messages){
		this.usuarioService = usuarioService;
		this.carteiraService = carteiraService;
		this.messages = messages;
	}

	@GetMapping("/home")
	public void getHome(@AuthenticationPrincipal ImplUsuario activeUser){
		this.home(activeUser);
	}

	@GetMapping("/")
	public String home(@AuthenticationPrincipal ImplUsuario activeUser) {
		return "redirect:/layouts/home" + activeUser.getUsuario().getId();
	}

	@GetMapping("/home/{id}")
	public String getPaginaInicial(Model model, @PathVariable Long id, Principal principal,
			@AuthenticationPrincipal ImplUsuario activeUser){

		Usuario u = usuarioService.findOne(id);
		Carteira cart = carteiraService.findOne(u.getCarteira().getId());

		model.addAttribute("usuario", u);
		model.addAttribute("carteira", cart);

		return "/layouts/home";
	}

}

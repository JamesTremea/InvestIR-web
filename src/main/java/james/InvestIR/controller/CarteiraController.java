package james.InvestIR.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import james.InvestIR.domain.Ativo;
import james.InvestIR.domain.AtivoCarteira;
import james.InvestIR.domain.Carteira;
import james.InvestIR.domain.Usuario;
import james.InvestIR.service.CarteiraService;
import james.InvestIR.service.TipoAtivoService;
import james.InvestIR.service.UsuarioService;
import james.InvestIR.util.DateUtil;
import james.InvestIR.service.AtivoCarteiraService;
import james.InvestIR.service.AtivoService;

/**
 * created by james on 22/05/2017
*/

@Controller
@RequestMapping("/carteira")
public class CarteiraController {

	private final CarteiraService carteiraService;
	private final AtivoCarteiraService ativoCarteiraService;
	private final TipoAtivoService tipoAtivoService;
	private final AtivoService ativoService;
	private final UsuarioService usuarioService;

	public CarteiraController(CarteiraService carteiraService, AtivoCarteiraService ativoCarteiraService,
				TipoAtivoService tipoAtivoService, AtivoService ativoService, UsuarioService usuarioService){
		this.carteiraService = carteiraService;
		this.ativoCarteiraService = ativoCarteiraService;
		this.tipoAtivoService = tipoAtivoService;
		this.ativoService = ativoService;
		this.usuarioService = usuarioService;
	}


	@GetMapping("/carteira")
	public String getPaginaCarteira(Model model){
		Carteira cart = carteiraService.findOne(1L);
		if (cart == null)
			this.getPaginaCarteiraInicial(model);
		model.addAttribute("carteira", cart);
		return "/carteira/carteira";
	}


	@GetMapping("/carteiraInicial")
	public String getPaginaCarteiraInicial(Model model){
		Carteira cart = new Carteira();
		cart.setDataRef(DateUtil.getToday());
		cart = carteiraService.findOne(1L);
		if(cart.getDataRef()==null)
			cart.setDataRef(DateUtil.parseStringToDate("01-01-2000"));
		model.addAttribute("carteira", cart);
		model.addAttribute("tiposAtivo", tipoAtivoService.getAll());
		model.addAttribute("ativoCarteira", new AtivoCarteira());
		return "/carteira/carteiraInicial";
	}


	@PostMapping("/saveWallet")
	public String salvaCarteira(Model model, @Valid Carteira cart, BindingResult bindingResult,
			@RequestParam(value = "userId", required = true) Long userId){
		Usuario us = usuarioService.findOne(userId);
		cart.setUsuario(us);
		Carteira carteira = carteiraService.save(cart);
		model.addAttribute("carteira", carteira);
		return "redirect:/carteira/carteiraInicial";
	}


	@PostMapping("/saveAsset")
	public String salvaAtivoCarteira(@Valid AtivoCarteira ativoCarteira, BindingResult bindingResult, Model model,
			@RequestParam(value = "carteiraId", required = true) Long carteiraId,
			@RequestParam(value = "ativoId", required = true) Long ativoId){

		Carteira cart = carteiraService.findOne(carteiraId);

		if (cart == null){
			cart = new Carteira();
			carteiraService.save(cart);
		}
		Ativo at = ativoService.findOne(ativoId);
		ativoCarteira.setCarteira(cart);
		ativoCarteira.setAtivo(at);

		try{
			ativoCarteiraService.save(ativoCarteira);
		}catch (Exception e){

		}

		return "redirect:/carteira/carteiraInicial";
	}

	@PostMapping("/removeAsset")
	public String removeAtivoCarteira(@Valid AtivoCarteira ac, BindingResult bindingResult,Model model,
			@RequestParam(value = "carteiraId", required = true) Long carteiraId,
			@RequestParam(value = "ativoTicker", required = true) String ativoTicker){

		Carteira cart = carteiraService.findOne(carteiraId);

		List<Ativo> la = new ArrayList<>();
		la = ativoService.buscaPorTicker(ativoTicker);
		ac.setCarteira(cart);
		ac.setAtivo(la.get(0));
		ativoCarteiraService.delete(ac);

		return "redirect:/carteira/carteiraInicial";
	}


}

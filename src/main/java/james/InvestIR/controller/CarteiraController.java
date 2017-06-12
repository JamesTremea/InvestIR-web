package james.InvestIR.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import james.InvestIR.domain.Ativo;
import james.InvestIR.domain.AtivoCarteira;
import james.InvestIR.domain.Carteira;
import james.InvestIR.domain.TipoAtivo;
import james.InvestIR.service.CarteiraService;
import james.InvestIR.service.TipoAtivoService;
import james.InvestIR.util.DateUtil;
import james.InvestIR.service.AtivoCarteiraService;

@Controller
public class CarteiraController {

	private final CarteiraService carteiraService;
	private final AtivoCarteiraService ativoCarteiraService;
	private final TipoAtivoService tipoAtivoService;

	public CarteiraController(CarteiraService carteiraService, AtivoCarteiraService ativoCarteiraService, TipoAtivoService tipoAtivoService){
		this.carteiraService = carteiraService;
		this.ativoCarteiraService = ativoCarteiraService;
		this.tipoAtivoService = tipoAtivoService;
	}


	@GetMapping("/carteira")
	public String getWalletPage(Model model){
		Carteira cart = carteiraService.findOne(1L);
		if (cart == null)
			this.getStarterWalletPage(model);
		model.addAttribute("carteira", cart);
		return "/carteira/carteira";
	}


	@GetMapping("/carteiraInicial")
	public String getStarterWalletPage(Model model){
		Carteira cart = new Carteira();
		cart.setDataRef(DateUtil.getToday());
		cart = carteiraService.findOne(1L);
		List<TipoAtivo> tiposAtivo = tipoAtivoService.getAll();
		List<AtivoCarteira> ativosCarteira = new ArrayList<>();
		model.addAttribute("carteira", cart);
		model.addAttribute(tiposAtivo);
		model.addAttribute(ativosCarteira);
		return "/carteira/carteiraInicial";
	}


	@PostMapping("/saveWallet")
	public String saveWallet(Model model, @Valid Carteira cart, BindingResult bindingResult){
		Carteira carteira = carteiraService.save(cart);
		model.addAttribute("carteira", carteira);
		return "redirect:/carteira/carteira";
	}


	@PostMapping("/saveAssets")
	public String saveAssets(Model model, @Valid List<AtivoCarteira> ac, BindingResult bindingResult,
			@RequestParam(value = "walletId", required = true) Long walletId){
		Carteira cart = carteiraService.findOne(walletId);
		if (cart == null)
			cart = new Carteira();
		cart.setAtivosCarteira(ac);
		carteiraService.save(cart);
		model.addAttribute("carteira", cart);
		return "redirect:/carteira/carteira";
	}


}

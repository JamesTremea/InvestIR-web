package james.InvestIR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import james.InvestIR.domain.Nota;
import james.InvestIR.service.AtivoNotaService;
import james.InvestIR.service.NotaService;

@Controller
public class NotaController {

	private final NotaService notaService;
	private final AtivoNotaService ativoNotaService;

	private NotaController(NotaService notaService, AtivoNotaService ativoNotaService){
		this.notaService = notaService;
		this.ativoNotaService = ativoNotaService;
	}

	@GetMapping("/notas")
	public String getPaginaNotas(){
		return "/notas/notas";
	}

	public String salvaNota(Nota nota){
		// TODO - implementar método para salvar nota
		return "/notas/notas";
	}

}

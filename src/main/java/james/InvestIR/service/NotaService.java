package james.InvestIR.service;

import james.InvestIR.domain.Ativo;
import james.InvestIR.domain.AtivoNota;
import james.InvestIR.domain.Nota;
import james.InvestIR.repository.AtivoRepository;
import james.InvestIR.repository.NotaRepository;

import org.springframework.stereotype.Service;

/**
 * Created by James on 14/06/2017.
 */

@Service
public class NotaService {

	private final NotaRepository notaRepository;
    private final AtivoNotaService ativoNotaService;


    public NotaService(NotaRepository notaRepository, AtivoNotaService ativoNotaService) {
    	this.notaRepository = notaRepository;
    	this.ativoNotaService = ativoNotaService;
    }

    public void save(Nota nota) {
    	notaRepository.save(nota);
    	for(AtivoNota an : nota.getAtivosNota()){
    		ativoNotaService.save(an);
    	}
    }


    public Nota findOne(Long id){
    	return notaRepository.findOne(id);
    }

}

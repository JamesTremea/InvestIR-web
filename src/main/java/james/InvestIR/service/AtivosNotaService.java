package james.InvestIR.service;

import james.InvestIR.domain.AtivosNota;
import james.InvestIR.repository.AtivosNotaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Created by James on 15/06/2017.
 */

@Service
public class AtivosNotaService {

	private final AtivosNotaRepository ativoNotaRepository;
	private final AtivoService ativoService;

    public AtivosNotaService(AtivosNotaRepository ativoNotaRepository, AtivoService ativoService) {
         this.ativoNotaRepository = ativoNotaRepository;
         this.ativoService = ativoService;

    }

    public AtivosNota save(AtivosNota ativoNota) {
    	return ativoNotaRepository.save(ativoNota);
    }

    public AtivosNota findOne(Long id){
    	return ativoNotaRepository.findOne(id);
    }

    public List<AtivosNota> findAllByNotaId(Long id){
    	return ativoNotaRepository.findAllByNotaId(id);
    }


}

package james.InvestIR.service;

import james.InvestIR.domain.AtivoNota;
import james.InvestIR.repository.AtivoNotaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Created by James on 15/06/2017.
 */

@Service
public class AtivoNotaService {

	private final AtivoNotaRepository ativoNotaRepository;
	private final AtivoService ativoService;

    public AtivoNotaService(AtivoNotaRepository ativoNotaRepository, AtivoService ativoService) {
         this.ativoNotaRepository = ativoNotaRepository;
         this.ativoService = ativoService;

    }

    public AtivoNota save(AtivoNota ativoNota) {
    	return ativoNotaRepository.save(ativoNota);
    }

    public AtivoNota findOne(Long id){
    	return ativoNotaRepository.findOne(id);
    }

    public List<AtivoNota> findAllByNotaId(Long id){
    	return ativoNotaRepository.findAllByNotaId(id);
    }


}

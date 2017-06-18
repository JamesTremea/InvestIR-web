package james.InvestIR.service;

import james.InvestIR.domain.Ativo;
import james.InvestIR.repository.AtivoRepository;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class AtivoService {

    private final AtivoRepository ativoRepository;

    public AtivoService(AtivoRepository ativoRepository) {
         this.ativoRepository = ativoRepository;
    }

    public Ativo save(Ativo ativo) {
    	return ativoRepository.save(ativo);
    }


    public Ativo findOne(Long id){
    	return ativoRepository.findOne(id);
    }

    public List<Ativo> buscaPorTicker(String ticker){
    	return ativoRepository.findByTickerContainingIgnoreCase(ticker);
    }

}

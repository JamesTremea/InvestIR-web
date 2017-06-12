package james.InvestIR.service;

import james.InvestIR.domain.TipoAtivo;
import james.InvestIR.repository.TipoAtivoRepository;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class TipoAtivoService {

    private final TipoAtivoRepository tipoAtivoRepository;

    public TipoAtivoService(TipoAtivoRepository tipoAtivoRepository) {
         this.tipoAtivoRepository = tipoAtivoRepository;
    }

    public TipoAtivo getOne(int id){
    	TipoAtivo ta = tipoAtivoRepository.findOne(id);
     	return ta;
    }

    public TipoAtivo findOne(String desc){
    	TipoAtivo ta = tipoAtivoRepository.findOneByDesc(desc);
    	if (ta == null){
    		ta = new TipoAtivo();
    		ta.setDesc(desc);
    		return tipoAtivoRepository.save(ta);
    	}
    	return ta;
    }

    public List<TipoAtivo> getAll(){
    	return tipoAtivoRepository.findAll();
    }

}

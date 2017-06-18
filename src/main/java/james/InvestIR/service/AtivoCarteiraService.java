package james.InvestIR.service;

import james.InvestIR.domain.AtivoCarteira;
import james.InvestIR.repository.AtivoCarteiraRepository;
import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class AtivoCarteiraService {

    private final AtivoService ativoService;
    private final AtivoCarteiraRepository ativoCarteiraRepository;

    public AtivoCarteiraService(AtivoService ativoService, AtivoCarteiraRepository ativoCarteiraRepository) {
        this.ativoService = ativoService;
        this.ativoCarteiraRepository = ativoCarteiraRepository;
    }

    public AtivoCarteira save(AtivoCarteira ativoCarteira) {
       	return ativoCarteiraRepository.save(ativoCarteira);
    }

    public AtivoCarteira registraCompra(AtivoCarteira ativoCarteira ) {
    	AtivoCarteira ac = ativoCarteiraRepository.findOne(ativoCarteira.getId());
    	if (ac == null)
    		ac = new AtivoCarteira();
    	// Calculando o novo valor antes de salvar
    	ac.setQuantidade(ac.getQuantidade() + ativoCarteira.getQuantidade());
    	double val = ac.getValor() + ativoCarteira.getValor();
    	ac.setValor(val);
    	ac.setAtivo(ativoCarteira.getAtivo());
    	ac.setCarteira(ativoCarteira.getCarteira());
       	ativoCarteiraRepository.save(ac);
        return ac;
    }

    public AtivoCarteira registraVenda(AtivoCarteira ativoCarteira) {
    	AtivoCarteira ac = ativoCarteiraRepository.findOne(ativoCarteira.getId());
    	if (ac == null){																		// venda a descoberto
    		ac = new AtivoCarteira();
    		ac.setAtivo(ativoCarteira.getAtivo());
        	ac.setCarteira(ativoCarteira.getCarteira());
    		ac.setQuantidade(0 - ativoCarteira.getQuantidade());
           	ac.setValor(0 - ativoCarteira.getValor());
    	}else{
    		// Recalculando valor e quantidade antes de salvar
    		double val = ac.getValor() - (ativoCarteira.getQuantidade() * (ac.getValor() / ac.getQuantidade()));
    		ac.setValor(val);
    		ac.setQuantidade(ac.getQuantidade() - ativoCarteira.getQuantidade());
     	}
       	ativoCarteiraRepository.save(ac);
        return ac;
    }


    public AtivoCarteira findOne(Long id){
    	return ativoCarteiraRepository.findOne(id);
    }

}

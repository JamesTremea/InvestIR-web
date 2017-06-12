package james.InvestIR.service;

import james.InvestIR.domain.AtivoCarteira;
import james.InvestIR.domain.Carteira;
import james.InvestIR.domain.Usuario;
import james.InvestIR.repository.AtivoCarteiraRepository;
import james.InvestIR.repository.CarteiraRepository;
import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class AtivoCarteiraService {

    private final AtivoService ativoService;
    private final CarteiraService carteiraService;
    private final AtivoCarteiraRepository ativoCarteiraRepository;

    public AtivoCarteiraService(AtivoService ativoService, CarteiraService carteiraService
    		, AtivoCarteiraRepository ativoCarteiraRepository) {
        this.ativoService = ativoService;
        this.carteiraService = carteiraService;
        this.ativoCarteiraRepository = ativoCarteiraRepository;
    }

    public void save(AtivoCarteira ativoCarteira) {
       	ativoCarteiraRepository.save(ativoCarteira);
    }

    public AtivoCarteira registerPurchase(AtivoCarteira ativoCarteira ) {
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

    public AtivoCarteira registerSale(AtivoCarteira ativoCarteira) {
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

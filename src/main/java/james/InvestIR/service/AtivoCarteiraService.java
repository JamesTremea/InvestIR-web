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
    	// Calculando o preço médio antes de salvar
    	double val = ac.getPrecoMedio() * ac.getQuantidade();
    	ac.setQuantidade(ac.getQuantidade()+ativoCarteira.getQuantidade());
    	val += (ativoCarteira.getPrecoMedio() * ativoCarteira.getQuantidade());
    	ac.setPrecoMedio(val / ac.getQuantidade());

    	ac.setAtivo(ativoCarteira.getAtivo());
    	ac.setCarteira(ativoCarteira.getCarteira());

       	ativoCarteiraRepository.save(ac);

        return ac;
    }


    public AtivoCarteira findOne(Long id){
    	return ativoCarteiraRepository.findOne(id);
    }

}

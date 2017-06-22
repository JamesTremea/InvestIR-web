package james.InvestIR.service;

import james.InvestIR.domain.AtivoCarteira;
import james.InvestIR.domain.Carteira;
import james.InvestIR.repository.CarteiraRepository;
import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;
    private final AtivoCarteiraService ativoCarteiraService;

    public CarteiraService(CarteiraRepository carteiraRepository, AtivoCarteiraService ativoCarteiraService) {
        this.carteiraRepository = carteiraRepository;
        this.ativoCarteiraService = ativoCarteiraService;
    }

    public Carteira save(Carteira carteira) {
    	Carteira cart = carteiraRepository.save(carteira);
        for (AtivoCarteira ac : carteira.getAtivosCarteira()){
        	try{
        		ativoCarteiraService.save(ac);
        	}catch (Exception e){
        		
        		// TODO - executar tratamento para exibir mensagem de erro
        	}
        }
        return cart;
    }

    public Carteira findOne(Long id){
    	Carteira cart = carteiraRepository.findOne(id);
    	return cart;
    }

}

package james.InvestIR.service;

import james.InvestIR.domain.AtivoCarteira;
import james.InvestIR.domain.Carteira;
import james.InvestIR.domain.Usuario;
import james.InvestIR.repository.AtivoCarteiraRepository;
import james.InvestIR.repository.CarteiraRepository;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class CarteiraService {

    private final AtivoService ativoService;
    private final CarteiraRepository carteiraRepository;
    private final AtivoCarteiraRepository ativoCarteiraRepository;

    public CarteiraService(AtivoService ativoService, CarteiraRepository carteiraRepository, AtivoCarteiraRepository ativoCarteiraRepository) {
        this.ativoService = ativoService;
        this.carteiraRepository = carteiraRepository;
        this.ativoCarteiraRepository = ativoCarteiraRepository;
    }

    public Carteira save(Carteira carteira) {
    	Carteira cart = carteiraRepository.findOne(carteira.getId());

        if (cart == null){
            cart = carteiraRepository.save(carteira);
            for (AtivoCarteira ac : carteira.getAtivosCarteira()){
            	ativoCarteiraRepository.save(ac);
            }
        } else{

        }
        return cart;
    }


    public Carteira findOne(Long id){
    	Carteira cart = carteiraRepository.findOne(id);
    	List<AtivoCarteira> lac = ativoCarteiraRepository.findByCarteiraId(id);
    	if(lac.size() > 0)
    		cart.setAtivosCarteira(lac);
    	return cart;

    }

}

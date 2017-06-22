package james.InvestIR.service;

import james.InvestIR.domain.AtivoCarteira;
import james.InvestIR.domain.AtivosNota;
import james.InvestIR.repository.AtivoCarteiraRepository;
import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class AtivoCarteiraService {

//    private final AtivoService ativoService;
    private final AtivoCarteiraRepository ativoCarteiraRepository;

    public AtivoCarteiraService(AtivoService ativoService, AtivoCarteiraRepository ativoCarteiraRepository) {
 //       this.ativoService = ativoService;
        this.ativoCarteiraRepository = ativoCarteiraRepository;
    }

    public AtivoCarteira save(AtivoCarteira ativoCarteira) throws Exception {
       	if ((ativoCarteira.getValor()/ativoCarteira.getQuantidade()) <= 0){
    		// TODO - RNG024 - emitir alerta de preço médio inválido
    		throw new Exception("Preço médio do ativo em carteira não pode ser igual ou menor que R$ 0,00. Insira o valor correto.");
    	}
       	return ativoCarteiraRepository.save(ativoCarteira);
    }

    public AtivoCarteira registraCompra(AtivoCarteira ativoCarteira, AtivosNota ativoNota) throws Exception  {
    	AtivoCarteira ac = ativoCarteiraRepository.findOne(ativoCarteira.getId());
    	if (ac == null)
    		ac = new AtivoCarteira();
    	// Calculando o novo valor antes de salvar
    	ac.setQuantidade(ac.getQuantidade() + ativoCarteira.getQuantidade());
    	double val = ac.getValor() + ativoCarteira.getValor();
    	ac.setValor(val);
    	ac.setAtivo(ativoCarteira.getAtivo());
    	ac.setCarteira(ativoCarteira.getCarteira());

       	if ((ac.getValor()/ac.getQuantidade()) <= 0){
    		// TODO - RNG024 - emitir alerta de preço médio inválido
    		throw new Exception("Preço médio do ativo em carteira não pode ser igual ou menor que R$ 0,00. Insira o valor correto.");
    	}

       	ativoCarteiraRepository.save(ac);
        return ac;
    }

    public AtivoCarteira registraVenda(AtivoCarteira ativoCarteira){
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

	public void delete(AtivoCarteira ac) {
		AtivoCarteira ac2 = ativoCarteiraRepository.findByCarteiraIdAndAtivoId(ac.getCarteira().getId(),ac.getAtivo().getId());
		ativoCarteiraRepository.delete(ac2);
	}



}

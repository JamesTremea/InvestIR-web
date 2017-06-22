package james.InvestIR.service;

import james.InvestIR.domain.Conta;
import james.InvestIR.repository.ContaRepository;

import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta save(Conta conta) {
    	Conta cnt = contaRepository.save(conta);
        return cnt;
    }

    public Conta findOne(Long id){
    	Conta cnt = contaRepository.findOne(id);
    	return cnt;
    }

    public Conta getByUsuarioId(Long id){
    	Conta cnt = contaRepository.findByUsuarioId(id);
    	return cnt;
    }

    public boolean trocaSenha(Conta conta, String senha){
    	// TODO - implementar RNG020
    	if (conta.getUsuario().validaSenha(senha)){
    		conta.setSenha(senha);
    		return true;
    	}
    	return false;
    }

    public void solicitaRedefinicaoDeSenha(Conta conta){
    	// TODO - RNG021
    }

    public void resetaSenha(Conta conta){
    	// TODO - RNG021
    	this.trocaSenha(conta, "Senha_padrao_01");  // será gerada uma senha provisória aleatória
    }
}

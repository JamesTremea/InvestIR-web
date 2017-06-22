package james.InvestIR.service;

import james.InvestIR.domain.Carteira;
import james.InvestIR.domain.Conta;
import james.InvestIR.domain.ImplUsuario;
import james.InvestIR.domain.Papel;
import james.InvestIR.domain.Usuario;
import james.InvestIR.service.ContaService;
import james.InvestIR.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ContaService contaService;

    public UsuarioService(UsuarioRepository usuarioRepository, ContaService contaService) {
         this.usuarioRepository = usuarioRepository;
         this.contaService = contaService;
    }

    public Usuario save(Usuario usuario) {
    	return usuarioRepository.save(usuario);
    }

    public Usuario findOne(Long id){
    	return usuarioRepository.findOne(id);
    }

    private boolean verificaPremium(Usuario usuario){
    	// TODO - Implementar regra RNG017
    	Conta cnt = contaService.getByUsuarioId(usuario.getId());
    	for(Papel p : cnt.getPapeis()){
    		if(p.getPapel().toUpperCase().contains("PREMIUM")){
    			return true;
    		}
    	}
    	return false;
    }

    public boolean verificaMaioridade(Usuario usuario){
    	// TODO - Implementar regra RNG017
    	return (usuario.getIdade() > 18);
    }
}

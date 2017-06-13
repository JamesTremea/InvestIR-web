package james.InvestIR.service;

import james.InvestIR.domain.Ativo;
import james.InvestIR.domain.Usuario;
import james.InvestIR.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
         this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(Usuario usuario) {
    	return usuarioRepository.save(usuario);
    }


    public Usuario findOne(Long id){
    	return usuarioRepository.findOne(id);
    }

}

package james.InvestIR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.Usuario;

/**
 * created by james on 07_06_2017
*/

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

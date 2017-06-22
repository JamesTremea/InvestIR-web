package james.InvestIR.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.Conta;

/**
 * created by james on 18_06_2017
*/

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    public Optional<Conta> findByUsername(String username);

	public Conta findByUsuarioId(Long id);

}
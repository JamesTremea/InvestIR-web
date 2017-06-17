package james.InvestIR.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.Conta;

/**
 * created by james on 07_06_2017
*/

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByUsername(String username);
}
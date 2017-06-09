package james.InvestIR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.Carteira;

/**
 * created by james on 07_06_2017
*/

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

}

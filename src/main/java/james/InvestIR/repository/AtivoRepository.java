package james.InvestIR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.Ativo;

/**
 * created by james on 07_06_2017
*/

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {

	public List<Ativo> findByTickerContainingIgnoreCase(String ticker);
}

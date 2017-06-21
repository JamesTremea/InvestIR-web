package james.InvestIR.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.AtivoCarteira;

/**
 * created by james on 07_06_2017
*/

@Repository
public interface AtivoCarteiraRepository extends JpaRepository<AtivoCarteira, Long> {

	public List<AtivoCarteira> findAllByCarteiraId(Long carteiraId);

	public AtivoCarteira findByCarteiraIdAndAtivoId(Long carteiraId, Long ativoId);

}

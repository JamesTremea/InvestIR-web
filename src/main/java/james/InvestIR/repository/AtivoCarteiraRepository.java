package james.InvestIR.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import james.InvestIR.domain.Conta;
import james.InvestIR.domain.AtivoCarteira;

/**
 * created by james on 07_06_2017
*/

@Repository
public interface AtivoCarteiraRepository extends JpaRepository<AtivoCarteira, Long> {

//	Optional<Account> findByUsername(String username);
	List<AtivoCarteira> findByCarteiraId(Long carteiraId);

}

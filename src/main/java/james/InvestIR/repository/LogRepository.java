package james.InvestIR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.Log;

/**
 * created by james on 18_06_2017
*/

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
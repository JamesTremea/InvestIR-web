package james.InvestIR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.AtivosNota;

/**
 * created by james on 07_06_2017
*/

@Repository
public interface AtivosNotaRepository extends JpaRepository<AtivosNota, Long> {

	List<AtivosNota> findAllByNotaId(Long id);

}

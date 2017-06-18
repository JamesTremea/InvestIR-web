package james.InvestIR.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.TipoAtivo;

/**
 * created by james on 07_06_2017
*/

@Repository
public interface TipoAtivoRepository extends JpaRepository<TipoAtivo, Integer> {

	public List<TipoAtivo> findAll();

	List<TipoAtivo> findByDesc(String desc);

	public TipoAtivo findOneByDesc(String desc);
}

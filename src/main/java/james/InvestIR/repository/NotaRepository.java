package james.InvestIR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import james.InvestIR.domain.Nota;


@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

}
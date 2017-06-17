package james.InvestIR.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by james on 14/06/17.
 */

@Entity
public class Papel {

	@Id
	@GeneratedValue
	private int id;
	private String papel;
	@ManyToMany
	private Set<Conta> contas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}
}

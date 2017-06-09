package james.InvestIR.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by rodrigo on 3/18/17.
 */
@Entity
public class Role {

	@Id
	@GeneratedValue
	private int id;
	private String role;
	@ManyToMany
	private Set<Account> accounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}

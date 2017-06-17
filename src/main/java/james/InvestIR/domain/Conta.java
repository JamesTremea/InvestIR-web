package james.InvestIR.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by james on 14/06/17.
 */

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Long id;

	private String username;
	private String senha;
	private boolean ativo;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Papel> papeis;
	@OneToOne				//(fetch = FetchType.EAGER)
	private Usuario usuario;

	public Conta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(Set<Papel> papeis) {
		this.papeis = papeis;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
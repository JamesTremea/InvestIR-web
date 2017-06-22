package james.InvestIR.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import james.InvestIR.util.DateUtil;

/**
 * created by james on 27_05_2017
*/

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String email;
	private String celular;
	private String tipoUsuario;
	private Long cpf;
	private Date dataNasc;
	@OneToOne
	private Carteira carteira;

	public Usuario(){

	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	@Transient
	public int getIdade(){
		return DateUtil.getAge(this.dataNasc);
	}

	@Transient
	public boolean validaSenha(String senha){
		// TODO - RNG019    (Esta implementação fica aqui para evitar o acesso indevido
		// a dados sensíveis como CPF, data de nascimento e Nome do Usuário)
		return true;
	}

}

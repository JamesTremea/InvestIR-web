package james.InvestIR.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class AtivoNota {

	@Id
	@GeneratedValue
	private long id;
	private EnumOperacao operacao;
	private int quantidade;
	private double valor;
	@ManyToOne
	private Ativo ativo;
	@ManyToOne
	private Nota nota;

	public AtivoNota(){

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public EnumOperacao getOperacao() {
		return operacao;
	}

	public void setOperacao(EnumOperacao operacao) {
		this.operacao = operacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

}

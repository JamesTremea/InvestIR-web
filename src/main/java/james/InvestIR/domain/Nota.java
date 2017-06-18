package james.InvestIR.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * created by james on 27_05_2017
*/

@Entity
public class Nota {

	@Id
	@GeneratedValue
	private long id;
	private long numero;
	private String corretora;
	private Date dataExec;
	private Date dataLiq;
	private double corretagem;
	private double emolumentos;
	private double irrf;
	private double taxas;
	@OneToMany															//(mappedBy = "ativo", fetch = FetchType.EAGER)
	private List<AtivoNota> ativosNota;

	public Nota(){

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getCorretora() {
		return corretora;
	}

	public void setCorretora(String corretora) {
		this.corretora = corretora;
	}

	public Date getDataExec() {
		return dataExec;
	}

	public void setDataExec(Date dataExec) {
		this.dataExec = dataExec;
	}

	public Date getDataLiq() {
		return dataLiq;
	}

	public void setDataLiq(Date dataLiq) {
		this.dataLiq = dataLiq;
	}

	public double getCorretagem() {
		return corretagem;
	}

	public void setCorretagem(double corretagem) {
		this.corretagem = corretagem;
	}

	public double getEmolumentos() {
		return emolumentos;
	}

	public void setEmolumentos(double emolumentos) {
		this.emolumentos = emolumentos;
	}

	public double getIrrf() {
		return irrf;
	}

	public void setIrrf(double irrf) {
		this.irrf = irrf;
	}

	public double getTaxas() {
		return taxas;
	}

	public void setTaxas(double taxas) {
		this.taxas = taxas;
	}

	public List<AtivoNota> getAtivosNota() {
		return ativosNota;
	}

	public void setAtivosNota(List<AtivoNota> ativosNota) {
		this.ativosNota = ativosNota;
	}

}

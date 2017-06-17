package james.InvestIR.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * created by james on 22/05/2017
*/

@Entity
public class Carteira {

	@Id
	@GeneratedValue
	private long id;
	private double credIrrf;
	private double prejNormal;
	private double prejDaytrade;
	private double prejFii;
	private Date dataRef;
	private Date ultimaAtualizacao;
	@OneToOne
	private Usuario usuario;
	@OneToMany(mappedBy = "carteira", fetch = FetchType.EAGER)
	private List<AtivoCarteira> ativosCarteira;


	public Carteira(){
		this.ativosCarteira = new ArrayList<AtivoCarteira>();
	}

	public Carteira(ArrayList<AtivoCarteira> lac){
		this.ativosCarteira = lac;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getCredIrrf() {
		return credIrrf;
	}

	public void setCredIrrf(double credIrrf) {
		this.credIrrf = credIrrf;
	}

	public double getPrejNormal() {
		return prejNormal;
	}

	public void setPrejNormal(double prejNormal) {
		this.prejNormal = prejNormal;
	}

	public double getPrejDaytrade() {
		return prejDaytrade;
	}

	public void setPrejDaytrade(double prejDaytrade) {
		this.prejDaytrade = prejDaytrade;
	}

	public double getPrejFii() {
		return prejFii;
	}

	public void setPrejFii(double prejFii) {
		this.prejFii = prejFii;
	}

	public Date getDataRef() {
		return dataRef;
	}

	public void setDataRef(Date dataRef) {
		this.dataRef = dataRef;
	}

	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AtivoCarteira> getAtivosCarteira() {
		return ativosCarteira;
	}

	public void setAtivosCarteira(List<AtivoCarteira> ativosCarteira) {
		this.ativosCarteira = ativosCarteira;
	}


	public void addAtivoCarteira(AtivoCarteira ativoCarteira) {
		this.ativosCarteira.add(ativoCarteira);
	}
}

package james.InvestIR.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by james on 18/06/17.
 */

@Entity
public class Log {

	@Id
	private Long id;
	private Date data;
	private String conteudo;

	public Log() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}

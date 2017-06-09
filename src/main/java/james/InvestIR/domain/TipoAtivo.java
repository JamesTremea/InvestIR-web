package james.InvestIR.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * created by james on 27_05_2017
*/

@Entity
public class TipoAtivo {

	@Id
	@GeneratedValue
	private int id;
	private String desc;

	public TipoAtivo(){

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}

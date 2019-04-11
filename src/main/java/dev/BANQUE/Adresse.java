package dev.BANQUE;

import javax.persistence.*;

@Embeddable //obligatoire
public class Adresse {
	@Column(name="NUMERO")
	private Integer num;
	
	@Column(name="RUE")
	private String rue;
	
	@Column(name="CODE_POSTAL")
	private Integer codepostal;
	
	@Column(name="VILLE")
	private String ville;
	

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(Integer codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [num=" + num + ", rue=" + rue + ", codepostal=" + codepostal + ", ville=" + ville + "]";
	}
}
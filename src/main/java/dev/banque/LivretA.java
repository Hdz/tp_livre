package dev.banque;

import javax.persistence.*;

@Entity
public class LivretA extends Compte{
	@Column(name="TAUX")
	private Double taux;

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "LivretA [taux=" + taux + "]";
	}
}

package dev.banque;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class AssuranceVie extends Compte {
	@Column(name="DATE_FIN")
	private LocalDate datefin;
	
	@Column(name="TAUX")
	private Double taux;

	public LocalDate getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}


}

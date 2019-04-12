package dev.banque;

import javax.persistence.*;

@Entity
public class Virement extends Operation{
	@Column(name="BENEFICIAIRE")
	private String beneficiaire;

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
}

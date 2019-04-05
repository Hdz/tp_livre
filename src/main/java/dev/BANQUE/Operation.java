package dev.BANQUE;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity //obligatoire
@Table(name="Operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
	@Id // obligatoire
	@Column(name="DATE")
	private LocalDateTime date;
	
	@Column(name="prenom")
	private Double montant;
	
	@Column(name="AUTEUR")
	private String motif;
	
	@ManyToOne
	private Compte compte;	

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	@Override
	public String toString() {
		return "Operation [date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
}

package dev.BANQUE;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //obligatoire
@Table(name="Client")
public class Client {
	@Id // obligatoire
	@Column(name="NOM")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="ddn")
	private LocalDate dateNaissance;

	@OneToMany
	private List<Compte> compte ;	
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	private Banque banque;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Compte> getCompte() {
		return compte;
	}

	public void setCompte(List<Compte> compte) {
		this.compte = compte;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", compte=" + compte
				+ ", adresse=" + adresse + ", banque=" + banque + "]";
	}

	
		
	

}


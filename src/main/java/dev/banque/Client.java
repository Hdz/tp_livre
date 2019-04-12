package dev.banque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity //obligatoire
@Table(name="client")
public class Client {
	@Id // obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", updatable=false, nullable=false)
	private Long id;

	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;
	
	@Column(name="DDN")
	private LocalDate dateNaissance;


	@ManyToMany (cascade = {CascadeType.ALL})
	@JoinTable(name = "correspondance",
			joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID")
	)
	private List<Compte> comptes ;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne (cascade = {CascadeType.ALL})
	@JoinColumn(name="ID_BANQUE")
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
		return comptes;
	}

	public void setCompte(List<Compte> comptes) {
		this.comptes = comptes;
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
		return "Client [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", comptes=" + comptes
				+ ", adresse=" + adresse + ", banque=" + banque + "]";
	}





}


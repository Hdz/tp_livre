package dev.demo;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity // obligatoire
@Table(name="CLIENT")
public class Client {

	@Id // obligatoire
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;
	
	@ManyToOne
	@JoinColumn(name="ID", insertable = false, updatable = false)
	private Livre livre;
	
	@OneToMany(mappedBy="client")
	private List<Emprunt> emprunt;
		

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public List<Emprunt> getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(List<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setTitre(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setAuteur(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
	

package dev.DEMO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="LIVRE")
public class Livre {

	@Id // obligatoire
	@Column(name="ID")
	private Integer id;
	
	@Column(name="TITRE")
	private String titre;
	
	@Column(name="AUTEUR")
	private String auteur;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}

}

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

package dev.demo;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="livre")
public class Livre {

	@Id // obligatoire
	@Column(name="ID")
	private Integer id;
	
	@Column(name="TITRE")
	private String titre;
	
	@Column(name="AUTEUR")
	private String auteur;
	
	@ManyToMany()
	@JoinTable(name="COMPO",
	joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"))
	private List<Emprunt> emprunt;

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

	public List<Emprunt> getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(List<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}

}


	
	


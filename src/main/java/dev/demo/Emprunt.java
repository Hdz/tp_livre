package dev.demo;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // obligatoire
@Table(name="EMPRUNT")
public class Emprunt {

	@Id // obligatoire
	@Column(name="ID")
	private Integer id;
	
	@Column(name="DATE_DEBUT")
	private Date date_debut;
	
	@Column(name="DELAI")
	private Integer delai;
	
	@Column(name="DATE_FIN")
	private Date date_fin;
	

	@ManyToMany(mappedBy="emprunt")
		private List<Livre> livres;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT", referencedColumnName = "ID",insertable = false, updatable = false)
	private Client client;


		
	
	public List<Livre> getLivres() {
		return livres;
	}


	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public Integer getDelai() {
		return delai;
	}


	public void setDelai(Integer delai) {
		this.delai = delai;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}




	
}


package dev.BANQUE;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //obligatoire
@Table(name="Banque")
public class Banque {
	@Id // obligatoire
	@Column(name="NOM")
	private String nom;

	@OneToMany
	private List<Client> clients;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Banque [nom=" + nom + "]";
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
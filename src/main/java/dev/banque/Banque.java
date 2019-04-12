package dev.banque;

import java.util.List;

import javax.persistence.*;

@Entity //obligatoire
@Table(name="banque")
public class Banque {
	@Id // obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", updatable=false, nullable=false)
	private Integer id;

	@Column(name="NOM")
	private String nom;

	@OneToMany(mappedBy = "banque", cascade = {CascadeType.ALL})
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
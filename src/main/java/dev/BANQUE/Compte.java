package dev.BANQUE;

import java.util.List;

import javax.persistence.*;

@Entity //obligatoire
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "compte")
public class Compte {
	@Id // obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name="NUMERO", nullable =false, updatable = false)
	private String numero;
	
	@Column(name="SOLDE")
	private Double solde;

	@ManyToMany(mappedBy = "comptes")
	private List<Client> clients;

	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", solde=" + solde + "]";
	}

	public List<Client> getClient() {
		return clients;
	}

	public void setClient(List<Client> clients) {
		this.clients = clients;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	
}

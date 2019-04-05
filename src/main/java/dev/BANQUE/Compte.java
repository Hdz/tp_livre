package dev.BANQUE;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //obligatoire
@Table(name="Compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	
	@Id // obligatoire
	@Column(name="numero")
	private String numero;
	
	@Column(name="solde")
	private Double solde;
	
	@ManyToMany
	@JoinTable(name = "CMP_CLIENTS", 
	joinColumns =  @JoinColumn(name="CMP_CLIENTS", referencedColumnName="numero"),
	inverseJoinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="nom"))
	private List<Client> client;
	
	@OneToMany
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
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	
}

package dev.BANQUE;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity //obligatoire
@Table(name="osperation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
	@Id // obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@Column(name="DATE")
	private LocalDateTime date;
	
	@Column(name="PRENOM")
	private Double montant;
	
	@Column(name="AUTEUR")
	private String motif;

	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private Compte compte;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Operation [date=" + date + ", id=" + id + ", montant=" + montant + ", motif=" + motif + "]";
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
}

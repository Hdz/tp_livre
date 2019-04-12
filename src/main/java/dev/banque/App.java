package dev.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


public class App {


	public static Banque createBank(String name) {
		Banque banque = new Banque();
		banque.setNom(name);
		return banque;
	}

	public static Adresse createAdress(int codePostal, int numRue, String libelleRue, String ville) {
		Adresse adresse = new Adresse();
		adresse.setCodepostal(codePostal);
		adresse.setNum(numRue);
		adresse.setRue(libelleRue);
		adresse.setVille(ville);
		return adresse;
	}

	public static Client createClient(String nom, String prenom, LocalDate dateNaissance, Banque banque,
			Adresse adresse) {
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setDateNaissance(dateNaissance);
		client.setBanque(banque);
		client.setAdresse(adresse);
		return client;
	}

	public static AssuranceVie createAssuranceVie(String identifiantCompte, double solde, double taux,
			LocalDate dateFin) {
		AssuranceVie compte = new AssuranceVie();
		compte.setNumero(identifiantCompte);
		compte.setSolde(solde);
		compte.setTaux(taux);
		compte.setDatefin(dateFin);
		return compte;
	}

	public static LivretA createLivretA(String identifiantCompte, double solde, double taux) {
		LivretA compte = new LivretA();
		compte.setNumero(identifiantCompte);
		compte.setSolde(solde);
		compte.setTaux(taux);
		return compte;
	}

	public static Virement createVirement(Compte compte, LocalDateTime date, double montant, String motif,
			String beneficiaire) {
		Virement operation = new Virement();
		operation.setCompte(compte);
		operation.setDate(date);
		operation.setMontant(montant);
		operation.setMotif(motif);
		operation.setBeneficiaire(beneficiaire);
		return operation;
	}

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_banque");

		// Insertion Banque
		Banque banque = createBank("BNP");
		Banque banque2 = createBank("CIC");
		Banque banque3 = createBank("LCL");


		// Insertion AssuranceVie
		AssuranceVie c = createAssuranceVie("compte1", 1500.0, 15.0, LocalDate.now());
		AssuranceVie c1 = createAssuranceVie("compte2", 100.0, 35.0, LocalDate.now());
		AssuranceVie c2 = createAssuranceVie("compte3", 8000.0, 20.0, LocalDate.now());
		AssuranceVie c3 = createAssuranceVie("compte4", 18000.0, 120.0, LocalDate.now());

		// Insertion Virements
		Virement op1 = createVirement(c, LocalDateTime.now(), 100.0, "Virement 1", "Pier");
		Virement op2 = createVirement(c1, LocalDateTime.now(), 100.0, "Fraude fisc", "Pol");
		Virement op3 = createVirement(c2, LocalDateTime.now(), 100.0, "Fraude fisc 2", "Jak");

		// Insertion Adresse
		Adresse adr1 = createAdress(44390, 1, "Rue Test", "PUCEUL");
		Adresse adr2 = createAdress(44390, 2, "Impasse de Maastricht", "Nort sur erdre");
		Adresse adr3 = createAdress(44000, 8, "Boulevard du Massacre", "Nantes");

		// Insertion Client
		Client cli1 = createClient("Jacky", "Pique", LocalDate.now(), banque, adr1);
		Client cli2 = createClient("John", "yBravo", LocalDate.now(), banque2, adr2);
		Client cli3 = createClient("Jauhn", "doeuf", LocalDate.now(), banque2, adr2);
		Client cli4 = createClient("Mike", "Brant", LocalDate.now(), banque3, adr3);

		// Jointure Compte de client
		List<Compte> compteClient1 = new ArrayList<>();
		compteClient1.add(c);
		cli1.setCompte(compteClient1);

		List<Compte> compteClient2 = new ArrayList<>();
		compteClient2.add(c1);
		cli2.setCompte(compteClient2);
		cli3.setCompte(compteClient2);

		List<Compte> compteClient3 = new ArrayList<>();
		compteClient3.add(c3);
		cli4.setCompte(compteClient3);

		// Jointure des opérations aux comptes
		List<Operation> listOpe1 = new ArrayList<>();
		listOpe1.add(op1);
		c.setOperations(listOpe1);

		List<Operation> listOpe2 = new ArrayList<>();
		listOpe2.add(op2);
		c.setOperations(listOpe2);

		List<Operation> listOpe3 = new ArrayList<>();
		listOpe3.add(op3);
		c.setOperations(listOpe3);

		// Convertion Objet en liste

		List<Banque> listBanque = new ArrayList<>();
		listBanque.add(banque);
		listBanque.add(banque2);

		List<Client> listClients = new ArrayList<>();
		listClients.add(cli1);
		listClients.add(cli2);
		listClients.add(cli3);
		listClients.add(cli4);

		List<Compte> listCompte = new ArrayList<>();
		listCompte.add(c);
		listCompte.add(c1);
		listCompte.add(c2);

		List<Operation> listOperation = new ArrayList<>();
		listOperation.add(op1);
		listOperation.add(op2);
		listOperation.add(op3);

		// Entity manager fait pour aller sur la BDD
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		// commit des donnees
		tx.begin();
		for (Banque b : listBanque) {
			em.persist(b);
		}
		tx.commit();

		tx.begin();
		for (Compte co : listCompte) {
			em.persist(co);
		}
		tx.commit();

		tx.begin();
		for (Operation op : listOperation) {
			em.persist(op);
		}
		tx.commit();

		tx.begin();
		for (Client c11 : listClients) {
			em.persist(c11);
		}
		tx.commit();

		em.close();
		emf.close();
	}

			}

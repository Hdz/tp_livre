package dev.BANQUE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.*;

public class App {

			public static void main(String[] args) {
				
				// Etape 1 - Créer une instance d'EntityManagerFactory
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_banque");
				// Début d'une unité de travail
				EntityManager em1 = emf.createEntityManager();
				AjoutBanque(emf);
				AjoutClient(emf);
				AjoutCompte(emf);	
				AjoutOperation(emf);
				AjoutVirements(emf);

			}
			public static void AjoutBanque(EntityManagerFactory emf) {
				Banque b = new Banque();
				b.setNom("BNP");
				EntityManager em = emf.createEntityManager();
				EntityTransaction transaction = em.getTransaction();
				transaction.begin();
				em.persist(b);
				transaction.commit();
				em.close();
			}
			
			public static void AjoutClient(EntityManagerFactory emf) {
				Client c = new Client();
				c.setNom("Geffroy");
				c.setPrenom("Michel");
				c.setAdresse(AjoutAdresse());
				c.setDateNaissance(LocalDate.of(1977, 12, 31));
				EntityManager em = emf.createEntityManager();
				EntityTransaction transaction = em.getTransaction();
				transaction.begin();
				em.persist(c);
				transaction.commit();
				em.close();

			}
			
			public static Compte AjoutCompte(EntityManagerFactory emf) {
				Compte cp = new Compte();
				cp.setNumero("000555444");
				cp.setSolde(50.00);
				EntityManager em = emf.createEntityManager();
				EntityTransaction transaction = em.getTransaction();
				transaction.begin();
				em.persist(cp);
				transaction.commit();
				em.close();
				return cp;
			}
			
			public static void AjoutOperation(EntityManagerFactory emf) {
				Operation op = new Operation();
				op.setDate(LocalDateTime.now());
				op.setMontant(50.00);
				op.setMotif("Changement numero 1");

				EntityManager em = emf.createEntityManager();
				EntityTransaction transaction = em.getTransaction();
				transaction.begin();
				em.persist(op);
				transaction.commit();
				em.close();

			}
			public static void AjoutVirements(EntityManagerFactory emf) {
				Virement vi = new Virement();
				String benef = "Geffroy";
				String cp = new Compte().getNumero();

				// Recupérer un client depuis la base

				//vi.setBeneficiaire(benef);

				vi.setMontant(58.00);
				vi.setMotif("Virement 1");
				
				
				EntityManager em = emf.createEntityManager();
				EntityTransaction transaction = em.getTransaction();
				transaction.begin();
				em.persist(vi);
				transaction.commit();
				em.close();
				
			}

			public static Adresse AjoutAdresse() {
			Adresse ad = new Adresse();
			ad.setCodepostal(44390);
			ad.setNum(7);
			ad.setRue("Close Benard");
			ad.setVille("Nantes");
			return ad;
			}
			
			}

package dev.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);


	public static void main(String[] args) {

		// Etape 1 - Créer une instance d'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_livre");
		
		// Début d'une unité de travail
		EntityManager em1 = emf.createEntityManager();
		
		// création d'une requête
		TypedQuery<Livre> requete = em1.createQuery("select l from Livre l", Livre.class);
		
		// GetResultat de la liste
		List<Livre> listeLivres = requete.getResultList();
		
		
		listeLivres.forEach(unLivre -> {
			LOG.info(unLivre.getId() + " - "  + unLivre.getTitre() + " - " + unLivre.getAuteur());
			
		});
		// Requête avec le em.find
		Livre requeteTitle2 = em1.find(Livre.class, 2);
		LOG.info(requeteTitle2.toString());
		
		// Requete JPQL pour trouver un livre en fonction de son titre
		String ref = "Guerre et paix" ;
		
		TypedQuery<Livre> requeteTitle = em1.createQuery("select l from Livre l where titre = :reference", Livre.class); 

		requeteTitle.setParameter("reference", ref);

		Livre book = requeteTitle.getSingleResult();
		System.out.println(book.toString());
		LOG.info(book.toString());

		
		// (Requete JPQL qui permet d'extraire un emprunt et tous ses livres associés)
		
		TypedQuery<Emprunt> requeteEmp = em1.createQuery("select e from Emprunt e ", Emprunt.class); 
		List<Emprunt> emp1 = requeteEmp.getResultList();
		emp1.forEach(unEmp -> {
			//System.out.println(unEmp.getId() + " - "  + unEmp.getLivres());
			LOG.info(unEmp.getId() + " - "  + unEmp.getLivres());
			
		});

		// (Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.)
		//System.out.println("Requête EMPRUNTS CLIENT \n");
		LOG.info("Requête EMPRUNTS CLIENT \\n");
		TypedQuery<Emprunt> requeteEmp2 = em1.createQuery("select e from Emprunt e, Client c where c.nom = 'Brigand' AND e.client = c.id", Emprunt.class); 

		List<Emprunt> emp2 = requeteEmp2.getResultList();
		emp2.forEach(unEmp2 -> {
			//System.out.println(unEmp2.getId() + " - "  + unEmp2.getClient());
			LOG.info(unEmp2.getId() + " - "  + unEmp2.getClient());
		});
		
		// (Insertion d'un livre)
		
		
		
		// Fin d'une unité de travail
		em1.close();
		
		emf.close();
		
		
		
	}

}
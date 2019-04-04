package dev.DEMO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

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
			System.out.println(unLivre.getId() + " - "  + unLivre.getTitre() + " - " + unLivre.getAuteur());
			
		});
		// Requête avec le em.find
		Livre requeteTitle2 = em1.find(Livre.class, 2);
		System.out.println(requeteTitle2);
		
		// Requete JPQL pour trouver un livre en fonction de son titre
		String ref = "Guerre et paix" ;
		
		TypedQuery<Livre> requeteTitle = em1.createQuery("select l from Livre l where titre = :reference", Livre.class); 

		requeteTitle.setParameter("reference", ref);

		Livre book = requeteTitle.getSingleResult();
		System.out.println(book.toString());
		
		
		
		

		// Fin d'une unité de travail
		em1.close();
		
		emf.close();
		
		
		
	}

}
package com.fitec.boutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fitec.boutique.entities.Commande;
import com.fitec.boutique.entities.Ligne_de_commande;

public class CommandeDAOImpl implements IDAOCommande {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Commande findById(long id) {

		return em.find(Commande.class, id);
	}

	
	@Override
	public void saveCommande(Commande commande) {

		if (commande != null) {
			try {
				em.persist(commande);
				List<Ligne_de_commande> panier = (List<Ligne_de_commande>) commande.getLigne_de_commandes();
				for (Ligne_de_commande ligne_de_commande : panier) {
					ligne_de_commande.setCommande(commande);
					em.merge(ligne_de_commande);
				}
			} catch (Exception e) {

			}
		}
		
	
	}

	@Override
	public void updateCommande(Commande commande) {
		if (commande != null) {
			try {
				em.merge(commande);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void deleteCommandeById(long id) {
		try {

			Commande commande = findById(id);
			em.remove(commande);

		} catch (Exception e) {

		}

	}

	@Override
	public List<Commande> findAllCommandes() {
		Query req = em.createQuery("select m from Commande m");
		return req.getResultList();
	}

	@Override
	public boolean isCommandeExist(Commande commande) {
		return findById(commande.getId_commande()) != null;
	}


	@Override
	public void saveLigneCommande(Ligne_de_commande ligneCommande) {
		em.persist(ligneCommande);
	}
	
	/*@Override
	public List<Article> articlesParMotCle(String mc) {
		Query req = em.createQuery("select a from Article a where a.prix_unitaire like :x");
		req.setParameter("x", "%" + mc + "%");
		return req.getResultList();
	}*/

}

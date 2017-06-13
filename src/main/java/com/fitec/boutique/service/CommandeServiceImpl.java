package com.fitec.boutique.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fitec.boutique.dao.IArticleDao;
import com.fitec.boutique.dao.IDAOClient;
import com.fitec.boutique.dao.IDAOCommande;
import com.fitec.boutique.dao.IDaoAdmin;
import com.fitec.boutique.entities.Article;
import com.fitec.boutique.entities.Categorie;
import com.fitec.boutique.entities.Client;
import com.fitec.boutique.entities.Commande;
import com.fitec.boutique.entities.Ligne_de_commande;

@Transactional
public class CommandeServiceImpl implements IServiceCommande{

	@Autowired
	private IDAOCommande daoCommande;
	
	@Autowired
	private IArticleDao daoArticle;
	
	@Autowired
	private IDAOClient daoClient;
	
	public IDAOCommande getDaoCommande() {
		return daoCommande;
	}

	public void setDaoCommande(IDAOCommande daoCommande) {
		this.daoCommande = daoCommande;
	}

	@Override
	public List<Commande> findAllCommandes() {
		List<Commande> listeCom = daoCommande.findAllCommandes();
		for (Commande com : listeCom){
			 com.getLigne_de_commandes().size(); //appeler .size() sur une collection "lazy" dans 
			                          //une méthode @Transactional remonte tout de suite val en memoire
			                         //--> pas de lazy exception coté web
		}
		return listeCom;
	}

	@Override
	public Commande findById(long id) {
		List<Commande> listeCom = daoCommande.findAllCommandes();
		Commande comSelected = null;
		for (Commande com : listeCom){
			if(com.getId_commande() == id){
				com.getLigne_de_commandes().size();
				comSelected = com;
			}
		}
		return comSelected;
	}

	/*@Override
	public Commande saveCommande(Commande commande) {
		
		return daoCommande.saveCommande(commande);
	}*/
	
	
	@Override
	public void saveCommande(Commande commande) {
		// TODO Auto-generated method stub
		
		// Faire find et rattachement pour un client 
		long idclient = 1; // commande.getIdClient();
		System.out.println("OK SerViCE INItiALISAtioN ");
		Client client = daoClient.findById(idclient);
		System.out.println("OK SerViCE APRES DAO REQUEST // CLIENT = " + client.toString());
		commande.setClient(client);
		
		// Faire find et rattachement pour l'article associé à chacune des lignes 
		List<Ligne_de_commande> listCommande = (List<Ligne_de_commande>) commande.getLigne_de_commandes();
		for (Ligne_de_commande ligne_de_commande : listCommande) {
				long idarticle = ligne_de_commande.getIdArticle();
				Article article = daoArticle.findById(idarticle);
				ligne_de_commande.setArticle(article);
			//	daoCommande.saveLigneCommande(ligne_de_commande);	
		}
		daoCommande.saveCommande(commande);
	}

	
	@Override
	public void updateCommande(Commande commande) {
		// TODO Auto-generated method stub
		daoCommande.updateCommande(commande);
	}

	@Override
	public void deleteCommandeById(long id) {
		// TODO Auto-generated method stub
		daoCommande.deleteCommandeById(id);
	}

	
	@Override
	public boolean isCommandeExist(Commande commande) {
		// TODO Auto-generated method stub
		return daoCommande.isCommandeExist(commande);
	}

	

}

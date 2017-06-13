package com.fitec.boutique;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fitec.boutique.entities.Admin;
import com.fitec.boutique.entities.Article;
import com.fitec.boutique.entities.Categorie;
import com.fitec.boutique.entities.Client;
import com.fitec.boutique.entities.Commande;
import com.fitec.boutique.entities.Ligne_de_commande;
import com.fitec.boutique.entities.Model;
import com.fitec.boutique.service.IServiceAdmin;
import com.fitec.boutique.service.IServiceCategorie;
import com.fitec.boutique.service.IServiceClient;
import com.fitec.boutique.service.IServiceCommande;
import com.fitec.boutique.service.IServiceModel;

import junit.framework.Assert;

public class TestJPA {

	ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });

	}

	

	/*	@Test
	public void test2() {
		
		try {
			//IServiceModel serviceModel = (IServiceModel) context.getBean("serviceModel");
			//IServiceCategorie serviceCategorie = (IServiceCategorie) context.getBean("serviceCategorie");
			
			
			
			/* // enrigestrer le couple de Model et Categorie
	        Model model1 = new Model("Model A", "rr", "eee");
	        Model model2 = new Model("Model B", "rr", "rr");
	        Model model3 = new Model("Model C", "rff", "ffr");
	       
	        
	        
	        Categorie cat1 = new Categorie("Cat A");
	        Categorie cat2 = new Categorie("Cat B");
			
	        (model1.getCategories()).add(cat1);
	        (model1.getCategories()).add(cat2);
	        
	        (model2.getCategories()).add(cat1);
	        (model2.getCategories()).add(cat2);
	        
	        (model3.getCategories()).add(cat1);
	        (model3.getCategories()).add(cat2);
	        
	        
	        serviceModel.saveModel(model1);
	        serviceModel.saveModel(model2);
	        serviceModel.saveModel(model3);
	        
	        // fetch all categorie
	       // for(Categorie categorie : serviceCategorie.findAllCategories()) {
	           
	         //  System.out.println(categorie.getModels());
	      //  }
	        
	        
			
		} catch (Exception e) {
			
		}
	}
	
	
	@Test
	public void test1() {

		try {

			IServiceModel serviceModel = (IServiceModel) context.getBean("serviceModel");
			IServiceCategorie serviceCategorie = (IServiceCategorie) context.getBean("serviceCategorie");
			
			 for(Model model : serviceModel.findAllModels()) {
		           
		           System.out.println(model.getCategories());
		        }
			
			
/*
			Categorie categorie1 = new Categorie();
			categorie1.setNom_cat("Homme1");

			Categorie categorie2 = new Categorie();
			categorie2.setNom_cat("Femme1");
			
			
			Model model1 = new Model();
			model1.setNom_model("Chaussure Adidas");
			(model1.getCategories()).add(categorie2);
			

			Model model2 = new Model();
			model2.setNom_model("Chaussure assisc");
			(model2.getCategories()).add(categorie1);
			
			serviceModel.saveModel(model1);
			serviceModel.saveModel(model2);
			
			//List<Model> model3= serviceModel.findAllModels();
			
		//	System.out.println(model3);
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	*/
	
	@Test
	public void testSaveCommande3() {
		
		try {
			
			// SETTING COMMANDE & LIGNES DE COMMANDE
			List<Ligne_de_commande> panier = new ArrayList<Ligne_de_commande>();
			Ligne_de_commande panier1 = (Ligne_de_commande) new Ligne_de_commande();
				panier1.setQuantite(3);
				panier1.setIdArticle(1);	
			Ligne_de_commande panier2 = (Ligne_de_commande) new Ligne_de_commande();
				panier2.setQuantite(1);
				panier2.setIdArticle(2);	
			panier.add(panier1);
			panier.add(panier2);
			
			Commande commande = new Commande();
				commande.setDate(new Date());
				commande.setAdresse_livraison("71 avenue du roule, Neuilly-Sur-Seine");
				commande.setIdClient(1);
				commande.setLigne_de_commandes(panier);
				
			// TEST DU SERVICE
			IServiceCommande serviceCommande = (IServiceCommande) context.getBean("serviceCommande");
			serviceCommande.saveCommande(commande);
	    
			
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}


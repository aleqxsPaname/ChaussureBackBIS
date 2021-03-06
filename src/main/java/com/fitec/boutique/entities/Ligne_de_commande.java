package com.fitec.boutique.entities;
/***********************************************************************
 * Module:  ligne_de_commande.java
 * Author:  Fitec
 * Purpose: Defines the Class ligne_de_commande
 ***********************************************************************/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ligne_de_commande")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Ligne_de_commande {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ligne_cmde")
	private long id_ligne_cmde;

	@Column(name="quantite")
	private int quantite;

	@ManyToOne
	@JoinColumn(name="id_article")
	@JsonIgnore
	private Article article;
	
	@Column(name="id_article", insertable=false,updatable=false)
	//@Transient
	private Long idArticle; //+get/set
	
	@ManyToOne
	@JoinColumn(name="id_commande")
	@JsonIgnore
	private Commande commande;
	
	public Ligne_de_commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ligne_de_commande(int quantite) {
		super();
		this.quantite = quantite;
	}

	public long getId_ligne_cmde() {
		return id_ligne_cmde;
	}

	public void setId_ligne_cmde(long id_ligne_cmde) {
		this.id_ligne_cmde = id_ligne_cmde;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Ligne_de_commande [id_ligne_cmde=" + id_ligne_cmde + ", quantite=" + quantite + "]";
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	// idArticle
	public long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(long idarticle) {
		this.idArticle = idarticle;
	}
	
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	
}
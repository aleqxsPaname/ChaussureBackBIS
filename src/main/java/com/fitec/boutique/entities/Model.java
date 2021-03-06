package com.fitec.boutique.entities;
/***********************************************************************
 * Module:  model.java
 * Author:  Fitec
 * Purpose: Defines the Class model
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="model")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Model implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_model")
	private long id_model;

	@Column(name="nom_model")
	private String nom_model;

	@Column(name="description")
	private String description;
	
	@Column(name="prix_unitaire")
	private float prix_unitaire;

	@Column(name="couleur")
	private String couleur;
	
	@OneToMany(mappedBy = "model")
	@JsonIgnore
	private Collection<Article> articles;
	
	@OneToMany(mappedBy = "model")
	@JsonIgnore
	private Collection<Photo> photos;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "model_categorie", joinColumns = @JoinColumn(name = "id_model"), inverseJoinColumns = @JoinColumn(name = "id_categorie"))
	@JsonIgnore
	private Collection<Categorie> categories;
	
	
	
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Model(String nom_model, String description, float prix_unitaire, String couleur) {
		super();
		this.nom_model = nom_model;
		this.description = description;
		this.prix_unitaire = prix_unitaire;
		this.couleur = couleur;
	}



	public Model(String nom_model, String description, float prix_unitaire, String couleur,
			Collection<Article> articles, Collection<Photo> photos, Collection<Categorie> categories) {
		super();
		this.nom_model = nom_model;
		this.description = description;
		this.prix_unitaire = prix_unitaire;
		this.couleur = couleur;
		this.articles = articles;
		this.photos = photos;
		this.categories = categories;
	}



	public long getId_model() {
		return id_model;
	}

	public void setId_model(long id_model) {
		this.id_model = id_model;
	}

	public String getNom_model() {
		return nom_model;
	}

	public void setNom_model(String nom_model) {
		this.nom_model = nom_model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	

	

	
	@Override
	public String toString() {
		return "Model [id_model=" + id_model + ", nom_model=" + nom_model + ", description=" + description
				+ ", prix_unitaire=" + prix_unitaire + ", couleur=" + couleur + ", articles=" + articles + ", photos="
				+ photos + ", categories=" + categories + "]";
	}



	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}

	public Collection<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Collection<Photo> photos) {
		this.photos = photos;
	}

	public Collection<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Categorie> categories) {
		this.categories = categories;
	}



	public float getPrix_unitaire() {
		return prix_unitaire;
	}



	public void setPrix_unitaire(float prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	

	

	

	
	
}
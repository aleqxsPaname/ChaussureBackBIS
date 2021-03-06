package com.fitec.boutique.service;

import java.util.List;

import com.fitec.boutique.entities.Model;

public interface IServiceModel {

	
	public Model findById(long id);

	public Model findByName(String name);

	public void saveModel(Model model);

	public void updateModel(Model model);

	public void deleteModelById(long id);

	public List<Model> findAllModels();
	
	boolean isModelExist(Model model);
}

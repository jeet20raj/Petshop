package com.example.petsupplies.core.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.petsupplies.core.backend.dao.CategoryDAO;
import com.example.petsupplies.core.backend.entity.CategoryEntity;
import com.example.petsupplies.core.common.constants.Constants;

@Path(Constants.PathConstants.CATEGORIES)
public class CategorySessionServiceImpl{

	@Inject
	private CategoryDAO categoryDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoryEntity> getCategories() {
		return categoryDAO.getCategories();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createCategory(CategoryEntity categoryEntity){
		if(categoryDAO.createCategory(categoryEntity)){
			return Constants.SUCCESS;
		}else{
			return Constants.FAILED;
		}
		
	}

	public boolean editCategory(CategoryEntity categoryEntity){
		return categoryDAO.createCategory(categoryEntity);
	}

	public boolean deleteCategory(CategoryEntity categoryEntity){
		return categoryDAO.deleteCategory(categoryEntity);
	}

}

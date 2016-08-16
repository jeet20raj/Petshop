package com.example.petsupplies.core.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.petsupplies.core.backend.dao.ProductDAO;
import com.example.petsupplies.core.backend.entity.ProductEntity;
import com.example.petsupplies.core.common.constants.Constants;
import com.example.petsupplies.core.model.ProductSearchFilter;


/**
 * ProductSessionServiceImpl is used to add/edit/display the products.
 * @author Jeetendra
 * @version 1.0
 * @since 2015-06-12
 */
@Path(Constants.PathConstants.PRODUCTS)
public class ProductSessionServiceImpl
{

   @Inject
   private ProductDAO productDAO;

   public List<ProductEntity> getProducts(ProductSearchFilter searchFilter)
   {
      // TODO Auto-generated method stub
      return productDAO.getProducts(searchFilter);
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<ProductEntity> getAllProducts()
   {
      return productDAO.getAllProducts();
   }

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.TEXT_PLAIN)
   public String createProduct(ProductEntity productEntity)
   {
      if(productDAO.createProduct(productEntity)){
    	  return Constants.SUCCESS;
      }else{
    	  return Constants.FAILED;
      }
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("{productId}")
   public ProductEntity getProduct(@PathParam("productId") Long productId)
   {
      return productDAO.getProduct(productId);
   }
   
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.TEXT_PLAIN)
   public String editProduct(ProductEntity productEntity)
   {
	   if(productDAO.editProduct(productEntity)){
	    	  return Constants.SUCCESS;
	      }else{
	    	  return Constants.FAILED;
	      }
   }

   public boolean deleteProduct(ProductEntity productEntity)
   {
      return productDAO.deleteProduct(productEntity);
   }

}

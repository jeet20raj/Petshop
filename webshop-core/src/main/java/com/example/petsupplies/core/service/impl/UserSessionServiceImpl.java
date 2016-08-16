package com.example.petsupplies.core.service.impl;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.petsupplies.core.backend.dao.UserDAO;
import com.example.petsupplies.core.backend.entity.UserEntity;
import com.example.petsupplies.core.common.constants.Constants;

/**
 * UserSessionServiceImpl is used to login and create user.
 * @author Jeetendra
 * @version 1.0
 * @since 2015-06-12
 */
@Path(Constants.PathConstants.USERS)
public class UserSessionServiceImpl
{
   @Inject
   private UserDAO userDAO;

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public UserEntity login(@QueryParam("userName") String userName,@QueryParam("password") String password)
   {
      return userDAO.login(userName, password);
   }
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public UserEntity createUser(UserEntity userEntity)
   {
      return userDAO.createUser(userEntity);
   }
}

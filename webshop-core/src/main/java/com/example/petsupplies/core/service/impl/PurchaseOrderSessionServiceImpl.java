package com.example.petsupplies.core.service.impl;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.petsupplies.core.backend.dao.PurchaseOrderDAO;
import com.example.petsupplies.core.backend.entity.CartItemEntity;
import com.example.petsupplies.core.backend.entity.OrderEntity;
import com.example.petsupplies.core.common.constants.Constants;

/**
 * PurchaseOrderSessionServiceImpl is used place order.
 * 
 * @author Jeetendra
 * @version 1.0
 * @since 2015-08-17
 */
@Path(Constants.PathConstants.ORDERS)
public class PurchaseOrderSessionServiceImpl {
	@Inject
	private PurchaseOrderDAO purchaseOrderDAO;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String processOrder(OrderEntity orderEntity) {
		for (CartItemEntity cartItemEntity : orderEntity.getCartItems()) {
			cartItemEntity.setOrderEntity(orderEntity);
		}
		if (purchaseOrderDAO.processOrder(orderEntity)) {
			return "Success";
		} else {
			return "Failed";
		}
	}
}

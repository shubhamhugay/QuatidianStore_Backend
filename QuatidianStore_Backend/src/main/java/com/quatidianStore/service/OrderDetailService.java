package com.quatidianStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatidianStore.configuration.JwtRequestFilter;
import com.quatidianStore.dao.OrderDetailDao;
import com.quatidianStore.dao.ProductDao;
import com.quatidianStore.dao.UserDao;
import com.quatidianStore.entity.OrderDetail;
import com.quatidianStore.entity.OrderInput;
import com.quatidianStore.entity.OrderProductQuantity;
import com.quatidianStore.entity.Product;
import com.quatidianStore.entity.User;


@Service
public class OrderDetailService {
	
	private static final String ORDER_PLACED="Placed";

	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	private ProductDao  productDao;
	
	@Autowired
	private UserDao userDao;
	
	
	
	
	public void placeOrder(OrderInput orderInput) 
	{
 List<OrderProductQuantity> productQuantityList =orderInput.getOrderProductQuantityList();
	
	for(OrderProductQuantity o: productQuantityList) {
		Product product =productDao.findById(o.getProductId()).get();
	         String	currentUser= JwtRequestFilter.CURRENT_USER;
	        User user = userDao.findById(currentUser).get();
		OrderDetail orderDetail =new OrderDetail(
				orderInput.getFullName(),
				orderInput.getFullAddress(),
				orderInput.getContactNumber(),
				orderInput.getAlternateContactNumber(),
				ORDER_PLACED,
				product.getProductActualPrice()*o.getQuantity(),
				product,
				user
				
				);
		
		orderDetailDao.save(orderDetail);
	}
	
	}
}

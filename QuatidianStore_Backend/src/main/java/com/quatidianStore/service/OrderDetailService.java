package com.quatidianStore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatidianStore.configuration.JwtRequestFilter;
import com.quatidianStore.dao.CartDao;
import com.quatidianStore.dao.OrderDetailDao;
import com.quatidianStore.dao.ProductDao;
import com.quatidianStore.dao.UserDao;
import com.quatidianStore.entity.Cart;
import com.quatidianStore.entity.OrderDetail;
import com.quatidianStore.entity.OrderInput;
import com.quatidianStore.entity.OrderProductQuantity;
import com.quatidianStore.entity.Product;
import com.quatidianStore.entity.User;

@Service
public class OrderDetailService {

	private static final String ORDER_PLACED = "Placed";

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	
	
	public void markOrderAsDelivered(Integer orderId) {
	OrderDetail orderDetail=	orderDetailDao.findById(orderId).get();
	if(orderDetail!=null) {
		orderDetail.setOrderStatus("Delivered");
		orderDetailDao.save(orderDetail);
	}	
	}
	
	
	
	
	
	
	
	
	
	
	
	public List<OrderDetail> getOrderDetails() 
	{
	String currentUser=JwtRequestFilter.CURRENT_USER;
	User user= userDao.findById(currentUser).get();
	
	return orderDetailDao.findByUser(user);
	}
	
	
	public List<OrderDetail> getAllOrderDetails(String status) {
		List<OrderDetail> orderDetails=new ArrayList<OrderDetail>();
		
		if(status.equals("All")) 
		{
			orderDetailDao.findAll().forEach(x->orderDetails.add(x));	
		}else {
			orderDetailDao.findByOrderStatus(status).forEach(x->orderDetails.add(x));
		}
		
	return orderDetails;
	}

	public void placeOrder(OrderInput orderInput, boolean isSingleProductCheckout) {
		List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();
		if (productQuantityList == null) {
			// Handle the case where the list is null, log an error, or throw an exception
			throw new IllegalArgumentException("OrderProductQuantityList cannot be null");
		}
		for (OrderProductQuantity o : productQuantityList) {
			Product product = productDao.findById(o.getProductId()).get();
			String currentUser = JwtRequestFilter.CURRENT_USER;
			User user = userDao.findById(currentUser).get();
			OrderDetail orderDetail = new OrderDetail(orderInput.getFullName(), orderInput.getFullAddress(),
					orderInput.getContactNumber(), orderInput.getAlternateContactNumber(), ORDER_PLACED,
					product.getProductActualPrice() * o.getQuantity(), product, user

			);
			if(!isSingleProductCheckout) {
				List<Cart> carts= cartDao.findByUser(user);
				carts.stream().forEach(x->cartDao.deleteById(x.getCartID()));
			}
			

			orderDetailDao.save(orderDetail);
		}

	}
}

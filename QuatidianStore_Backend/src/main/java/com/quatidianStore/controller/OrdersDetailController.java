package com.quatidianStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quatidianStore.entity.OrderInput;
import com.quatidianStore.service.OrderDetailService;


@RestController
public class OrdersDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	
	@PreAuthorize("hasRole('User')")
	@PostMapping({"/placeOrder"})
	public void placeOrder(@RequestBody OrderInput orderInput) 
	{
		orderDetailService.placeOrder(orderInput);
	}
	
}

package com.quatidianStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatidianStore.dao.ProductDao;
import com.quatidianStore.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public Product addnewProduct(Product product) 
	{
		return productDao.save(product);
	}
	
}

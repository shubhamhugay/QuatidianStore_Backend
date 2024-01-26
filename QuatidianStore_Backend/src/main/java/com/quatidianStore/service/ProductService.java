package com.quatidianStore.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quatidianStore.dao.ProductDao;
import com.quatidianStore.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public Product addnewProduct(Product product) {
		return productDao.save(product);
	}

	public List<Product> getAllProducts(int pageNumber, String searchKey) {
		// for a pagination
		Pageable pageable = PageRequest.of(pageNumber, 10);
		if (searchKey.equals("")) {
			return (List<Product>) productDao.findAll(pageable);

		} else {
			return productDao.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(searchKey, searchKey, pageable);
			}

	}

	public void deleteProductDetails(Integer productId) {
		productDao.deleteById(productId);
	}

	public Product getProductDetailById(Integer productId) {
		return productDao.findById(productId).get();

	}

	public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId) {

		if (isSingleProductCheckout) {
			// buy single
			List<Product> list = new ArrayList<>();
			Product product = productDao.findById(productId).get();
			list.add(product);
			return list;

		} else {

		}
		return new ArrayList<>();
	}

}

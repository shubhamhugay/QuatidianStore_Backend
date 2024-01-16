package com.quatidianStore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quatidianStore.entity.Product;
@Repository
public interface ProductDao  extends CrudRepository<Product, Integer>{

}

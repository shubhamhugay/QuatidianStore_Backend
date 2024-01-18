package com.quatidianStore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quatidianStore.entity.OrderDetail;

@Repository
public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {
	

}

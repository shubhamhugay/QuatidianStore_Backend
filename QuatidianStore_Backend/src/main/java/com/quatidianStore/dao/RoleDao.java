package com.quatidianStore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quatidianStore.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}

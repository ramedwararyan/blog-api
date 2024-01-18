package com.project.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.entities.Role;



public interface RoleRepo  extends JpaRepository<Role, Integer>{

}

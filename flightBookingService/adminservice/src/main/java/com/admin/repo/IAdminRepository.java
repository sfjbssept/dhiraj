package com.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entity.Inventory;


@Repository
public interface IAdminRepository extends JpaRepository<Inventory, Integer>{

}

package com.admin.service;

import java.util.List;
import java.util.Optional;

import com.admin.entity.Inventory;


public interface IAdminService {

		Integer addInventory(Inventory inventory);

		public  List<Inventory> getAllInventories();
			
		 Optional<Inventory> getInventory(Integer id);
		 
		 Inventory updateInvtory(Inventory inventory ,Integer id);
		 public void deleteInventory(Integer id);
		 
		 public void deleteAllInventory();

		}


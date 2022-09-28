package com.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.Inventory;
import com.admin.service.IAdminService;


@RestController
public class AdminController {
	@Autowired
	IAdminService adminService;
	
	@PostMapping("/addInventory")
      Integer addInventory(@RequestBody Inventory inventory) {
		Integer id=adminService.addInventory(inventory);
		System.out.println("iD---"+id);
		return id;
	}	
	
	@GetMapping("/allProducts")
    List<Inventory> getInventories() {
		return adminService.getAllInventories();
	}	


	@GetMapping("/inventory/{id}")
    Optional<Inventory> getInventoryById(@PathVariable Integer id) {
		return adminService.getInventory(id);
	}	

	
	@PutMapping("/update/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable("id") Integer id, @RequestBody Inventory inventory) {
		return new ResponseEntity<Inventory>(adminService.updateInvtory(inventory, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteInventory/{id}")
	public ResponseEntity<Inventory> deleteInventory(@PathVariable Integer id) {
		System.out.println(id);
		ResponseEntity<Inventory> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			adminService.deleteInventory(id);

		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return responseEntity;
	}

	@DeleteMapping("/deleteAllInventories")
	public ResponseEntity<Inventory> deleteProduct() {
		ResponseEntity<Inventory> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			adminService.deleteAllInventory();

		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return responseEntity;
	}

}

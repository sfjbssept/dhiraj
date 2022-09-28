package com.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.Inventory;
import com.admin.exception.ResourceNotFoundException;
import com.admin.repo.IAdminRepository;


@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository iAdminRepository;

	@Override
	public Integer addInventory(Inventory inventory) {
		Inventory addInventroy=iAdminRepository.save(inventory);
		return addInventroy.getId();
		}

	@Override
	public List<Inventory> getAllInventories() {
		// TODO Auto-generated method stub
		return iAdminRepository.findAll();
		}

	@Override
	public Optional<Inventory> getInventory(Integer id) {
		// TODO Auto-generated method stub
		return iAdminRepository.findById(id);
		}

	@Override
	public Inventory updateInvtory(Inventory inventory, Integer id) {
		Inventory exsitingInventory=iAdminRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Inventory","id",id));
		exsitingInventory.setAirlineName(inventory.getAirlineName());
		exsitingInventory.setFlightNumber(inventory.getFlightNumber());
		exsitingInventory.setEndDateTime(inventory.getEndDateTime());
		exsitingInventory.setFromPlace(inventory.getFromPlace());
		exsitingInventory.setInstrumentUsed(inventory.getInstrumentUsed());
		exsitingInventory.setScheduledDays(inventory.getScheduledDays());
		exsitingInventory.setTicketCost(inventory.getTicketCost());
		exsitingInventory.setToPlace(inventory.getToPlace());
		iAdminRepository.save(exsitingInventory);
		return exsitingInventory;
	}


	@Override
	public void deleteInventory(Integer id) {
		// TODO Auto-generated method stub

		iAdminRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllInventory() {
		// TODO Auto-generated method stub
		iAdminRepository.deleteAll();
		
	}

}

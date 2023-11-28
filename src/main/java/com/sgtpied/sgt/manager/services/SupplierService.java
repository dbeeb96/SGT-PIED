package com.sgtpied.sgt.manager.services;

import com.sgtpied.sgt.manager.models.Modules;
import com.sgtpied.sgt.manager.repositories.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
	@Autowired
	private ModulesRepository modulesRepository;
	
	//Get All Suppliers
	public List<Modules> findAll(){
		return modulesRepository.findAll();
	}	
	
	//Get Supplier By Id
	public Modules findById(int id) {
		return modulesRepository.findById(id).orElse(null);
	}	
	
	//Delete Supplier
	public void deleteById(int id) {
		modulesRepository.deleteById(id);
	}
	
	//Update Supplier
	public void save(Modules supplier) {
		modulesRepository.save(supplier);
	}

}

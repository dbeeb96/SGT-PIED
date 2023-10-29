package com.sgtpied.sgtpied.parameters.services;
import com.sgtpied.sgtpied.parameters.models.Module;

import com.sgtpied.sgtpied.parameters.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    //Get All Modules
    public List<Module> findAll(){
        return moduleRepository.findAll();
    }

    //Get Module By Id
    public Module findById(int id) {
        return moduleRepository.findById(id).orElse(null);
    }

    //Delete Module
    public void delete(int id) {
        moduleRepository.deleteById(id);
    }

    //Update Module
    public void save(Module module) {
        moduleRepository.save(module);
    }
}

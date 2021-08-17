package com.chris.driverslicense.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chris.driverslicense.dojosandninjas.models.Dojo;
import com.chris.driverslicense.dojosandninjas.models.Ninja;
import com.chris.driverslicense.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    
    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    }
    
    public Dojo updateDojo(Long id, String name, Ninja ninja) {
    	Dojo updatedDojo = findDojo(id);
    	if(updatedDojo!=null) {
    		updatedDojo.setName(name);
    		if(ninja!=null) {
    			List<Ninja> ninjaList = updatedDojo.getNinjas();
    			ninjaList.add(ninja);
    			updatedDojo.setNinjas(ninjaList);
    		}
    		dojoRepository.save(updatedDojo);
    	}
    	return updatedDojo;
    }
}

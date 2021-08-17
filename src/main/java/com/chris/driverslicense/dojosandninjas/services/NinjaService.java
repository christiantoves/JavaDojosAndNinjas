package com.chris.driverslicense.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chris.driverslicense.dojosandninjas.models.Ninja;
import com.chris.driverslicense.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    
    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
    
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id);
    }
    
    public Ninja updateNinja(Long id, String firstName, String lastName, int age) {
    	Ninja updatedNinja = findNinja(id);
    	if(updatedNinja!=null) {
    		updatedNinja.setFirstName(firstName);
    		updatedNinja.setLastName(lastName);
    		updatedNinja.setAge(age);
    		ninjaRepository.save(updatedNinja);
    	}
    	return updatedNinja;
    }
}

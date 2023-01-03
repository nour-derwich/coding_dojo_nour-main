package com.nour.Nunja.Servce;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nour.Nunja.Models.Ninja;
import com.nour.Nunja.Repository.NinjaRepository;




@Service
public class NinjaServce {
	//CRUD
	
    @Autowired
    private NinjaRepository ninjaRepo;
    // returns all the ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
    // creates a ninja
    public Ninja createNinja(Ninja n) {
        return ninjaRepo.save(n);
    }
    // retrieves a ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get() ;
        } else {
            return null;
        }
       
    }
	public Ninja updateNinja(Ninja b) {
		// TODO Auto-generated method stub
		return ninjaRepo.save(b);			
	}
	public void deleteNinja(Long id)
	{
		ninjaRepo.deleteById(id);
	}
}

package com.javaspring.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.dojosninjas.models.Ninja;
import com.javaspring.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public Ninja add(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	public List<Ninja> all() {
		return this.ninjaRepo.findAll();
	}
	
	public Ninja retrieveOne(Long id) {
		Optional<Ninja> optNinja = this.ninjaRepo.findById(id);
		if(optNinja.isPresent()) {
			return optNinja.get();
		} else {
			return null;
		}
	}
}

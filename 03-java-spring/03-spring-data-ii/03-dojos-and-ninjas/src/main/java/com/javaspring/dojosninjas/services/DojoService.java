package com.javaspring.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.dojosninjas.models.Dojo;
import com.javaspring.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	public Dojo add(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	public List<Dojo> all() {
		return this.dojoRepo.findAll();
	}
	
	public Dojo retrieveOne(Long id) {
		Optional<Dojo> optDojo = this.dojoRepo.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		} else {
			return null;
		}
	}
	
	
}

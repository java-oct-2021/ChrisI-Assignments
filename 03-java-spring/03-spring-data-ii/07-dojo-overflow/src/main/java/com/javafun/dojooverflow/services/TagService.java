package com.javafun.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafun.dojooverflow.models.Tag;
import com.javafun.dojooverflow.repositories.QuestionRepository;
import com.javafun.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepo;
	@Autowired
	private QuestionRepository questionRepo;
	
	public Tag add(Tag tag) {
		return this.tagRepo.save(tag);
	}
	
	public Tag exists(String tag) {
		return this.tagRepo.findBySubject(tag);
	}
}

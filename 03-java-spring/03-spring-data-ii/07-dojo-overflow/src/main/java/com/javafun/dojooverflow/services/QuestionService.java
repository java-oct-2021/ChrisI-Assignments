package com.javafun.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafun.dojooverflow.models.Question;
import com.javafun.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepo;
	
	public Question add(Question question) {
		return this.questionRepo.save(question);
	}
	
	public List<Question> retrieveAll() {
		return questionRepo.findAll();
	}
	
	public Question retrieveOne(Long questionId) {
		Optional<Question> q = this.questionRepo.findById(questionId);
		if(q.isPresent()) {
			return q.get();
		} else {
			return null;
		}
	}
}

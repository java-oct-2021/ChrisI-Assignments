package com.javafun.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafun.dojooverflow.models.Answer;
import com.javafun.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepo;
	
	public Answer add(Answer answer) {
		return this.answerRepo.save(answer);
	}
}

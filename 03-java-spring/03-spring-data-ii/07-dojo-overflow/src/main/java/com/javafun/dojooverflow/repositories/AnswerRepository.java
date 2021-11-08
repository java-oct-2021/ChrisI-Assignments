package com.javafun.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javafun.dojooverflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer,Long> {
	List<Answer> findAll();
}

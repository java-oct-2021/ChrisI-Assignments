package com.javafun.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javafun.dojooverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question,Long> {
	List<Question> findAll();
}

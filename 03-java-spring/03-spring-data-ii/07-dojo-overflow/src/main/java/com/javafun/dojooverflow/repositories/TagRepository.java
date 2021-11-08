package com.javafun.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javafun.dojooverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag,Long> {
	List<Tag> findAll();
	Tag findBySubject(String subject);
}

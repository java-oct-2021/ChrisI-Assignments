package com.javaspring.lang.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaspring.lang.models.Language;
import com.javaspring.lang.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository langRepo;

	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLanguages() {
		return this.langRepo.findAll();
	}
	
	public Language addLanguage(Language lang) {
		return this.langRepo.save(lang);
	}
	
	public Language retrieveLanguage(Long id) {
		Optional<Language> optLang = this.langRepo.findById(id);
		if(optLang.isPresent()) {
			return optLang.get();
		} else {
			return null;
		}
	}
	public void removeLanguage(Long id) {
		this.langRepo.deleteById(id);
	}
}

package com.sanad.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanad.languages.models.Language;
import com.sanad.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	// adding the book repository as a dependency
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	// returns all the languages
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}

	// creates a language
	public Language createLanguage(Language b) {
		return languageRepository.save(b);
	}

	// updates a language
	public Language updateLanguage(long id, Language updatedLanguage) {
		Optional<Language> l = languageRepository.findById(id);
		if (l.isPresent()) {
			Language language = l.get();
			language.setName(updatedLanguage.getName());
			language.setCreator(updatedLanguage.getCreator());
			language.setVersion(updatedLanguage.getVersion());
			return languageRepository.save(language);
		} else {
			return null;
		}

	}

	public void deleteLanguage(Long id) {
		Language language = this.findLanguage(id);
		languageRepository.delete(language);

	}

	// retrieves a language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
}

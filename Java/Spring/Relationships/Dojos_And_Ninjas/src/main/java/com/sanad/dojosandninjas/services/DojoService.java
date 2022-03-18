package com.sanad.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanad.dojosandninjas.models.Dojo;
import com.sanad.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	// adding the book repository as a dependency
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	// returns all the dojos
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	// creates a dojo
	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}

	// updates a dojo
	public Dojo updateDojo(long id, Dojo updatedDojo) {
		Optional<Dojo> l = dojoRepository.findById(id);
		if (l.isPresent()) {
			Dojo dojo = l.get();
			dojo.setName(updatedDojo.getName());

			return dojoRepository.save(dojo);
		} else {
			return null;
		}

	}

	public void deleteDojo(Long id) {
		Dojo dojo = this.findDojo(id);
		dojoRepository.delete(dojo);

	}

	// retrieves a dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}

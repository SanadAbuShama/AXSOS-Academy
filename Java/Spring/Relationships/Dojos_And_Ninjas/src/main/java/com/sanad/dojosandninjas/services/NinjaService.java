package com.sanad.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanad.dojosandninjas.models.Dojo;
import com.sanad.dojosandninjas.models.Ninja;
import com.sanad.dojosandninjas.repositories.DojoRepository;
import com.sanad.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	// adding the book repository as a dependency
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;

	public NinjaService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}

	// returns all the ninjas
	public List<Dojo> allNinjas() {
		return dojoRepository.findAll();
	}

	// creates a ninja
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}

}

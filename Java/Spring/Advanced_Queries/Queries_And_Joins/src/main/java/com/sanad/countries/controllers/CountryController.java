package com.sanad.countries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanad.countries.services.APIService;

//.. don't forget to inlcude all your imports! ..

@RestController
public class CountryController {

	@Autowired
	private APIService apiServ;

	@RequestMapping("/")
	public List<Object[]> index() {

		List<Object[]> cities = apiServ.citiesInArg();

		return cities;
	}

}

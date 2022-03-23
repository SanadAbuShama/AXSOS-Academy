package com.sanad.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanad.countries.repositories.CityRepository;
import com.sanad.countries.repositories.CountryRepository;
import com.sanad.countries.repositories.LanguageRepository;

@Service
public class APIService {

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private LanguageRepository languageRepo;

	// Number 1

	public List<Object[]> sloveneCountries() {
		return countryRepo.sloveneCountries();
	}

	// Number 2

	public List<Object[]> numCities() {
		return countryRepo.countryCities();
	}
	// Number 3

	public List<Object[]> mexicoCities() {
		return cityRepo.citiesInMexico();
	}

	// Number 4

	public List<Object[]> languagesInCountry() {
		return languageRepo.languagesByPercentage();
	}

	// Number 5

	public List<Object[]> countriesBySurfaceAreaAndPop() {
		return countryRepo.countriesBySurfaceArea();
	}

	// Number 6

	public List<Object[]> countriesWithSomeConditions() {
		return countryRepo.countriesWithTheseConditions();
	}

	// Number 7

	public List<Object[]> citiesInArg() {
		return cityRepo.citiesInBuenos();
	}

	// Number 8

	public List<Object[]> numCountriesInRegion() {
		return countryRepo.countriesInRegion();
	}

}
package com.sanad.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.countries.models.City;

//.. imports .. //

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

	List<City> findAll();

	@Query("SELECT c.name,c.population FROM City c JOIN c.country  WHERE c.country.name='Mexico' AND c.population > 500000 ORDER BY c.population DESC")
	List<Object[]> citiesInMexico();

	@Query("SELECT con.name,c.name,c.district,c.population FROM City c JOIN c.country con  WHERE con.name='Argentina' AND c.district='Buenos Aires' AND c.population > 500000")
	List<Object[]> citiesInBuenos();

}
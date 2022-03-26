package com.sanad.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.events.models.EventM;

//.. imports .. //

@Repository
public interface EventRepository extends CrudRepository<EventM, Long> {

	List<EventM> findAll();

	List<EventM> findByStateIs(String state);

	List<EventM> findByStateNot(String state);

}
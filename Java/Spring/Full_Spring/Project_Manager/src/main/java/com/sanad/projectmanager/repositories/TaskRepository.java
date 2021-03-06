package com.sanad.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.projectmanager.models.Task;

//.. imports .. //

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

	List<Task> findAll();

}
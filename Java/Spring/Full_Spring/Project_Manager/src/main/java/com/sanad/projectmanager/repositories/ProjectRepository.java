package com.sanad.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.projectmanager.models.Project;
import com.sanad.projectmanager.models.User;

//.. imports .. //

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	List<Project> findAll();

	List<Project> findByMembersNotContaining(User user);
}
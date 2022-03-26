package com.sanad.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.events.models.Comment;

//.. imports .. //

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

	List<Comment> findAll();

}
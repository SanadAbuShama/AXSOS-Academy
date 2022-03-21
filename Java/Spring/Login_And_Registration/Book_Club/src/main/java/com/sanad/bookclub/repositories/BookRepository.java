package com.sanad.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.bookclub.models.Book;

//.. imports .. //

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();

}
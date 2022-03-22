package com.sanad.bookbroker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.bookbroker.models.Book;
import com.sanad.bookbroker.models.User;

//.. imports .. //

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();

	List<Book> findByBorrowerNull();

	List<Book> findByBorrower(User borrower);

}
package com.sanad.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sanad.lookify.models.Song;

//...
//...
@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	// this method retrieves all the books from the database
	List<Song> findAll();

	// this method finds books with descriptions containing the search string
//	List<Language> findByDescriptionContaining(String search);
	List<Song> findByArtistContaining(String artist);

	List<Song> findTop10ByOrderByRatingDesc();
}

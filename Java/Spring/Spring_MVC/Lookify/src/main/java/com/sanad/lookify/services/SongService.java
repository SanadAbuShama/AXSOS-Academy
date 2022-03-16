package com.sanad.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanad.lookify.models.Song;
import com.sanad.lookify.repositories.SongRepository;

@Service
public class SongService {
	// adding the book repository as a dependency
	private final SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	// returns all the songs
	public List<Song> allSongs() {
		return songRepository.findAll();
	}

	// creates a song
	public Song createSong(Song b) {
		return songRepository.save(b);
	}

	// updates a song
	public Song updateSong(long id, Song updatedSong) {
		Optional<Song> l = songRepository.findById(id);
		if (l.isPresent()) {
			Song song = l.get();
			song.setTitle(updatedSong.getTitle());
			song.setArtist(updatedSong.getArtist());
			song.setRating(updatedSong.getRating());
			return songRepository.save(song);
		} else {
			return null;
		}

	}

	public void deleteSong(Long id) {
		Song song = this.findSong(id);
		songRepository.delete(song);

	}

	// retrieves a song
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}

	// Filters by artist

	public List<Song> findByArtist(String searchQuery) {
		return songRepository.findByArtistContaining(searchQuery);

	}

	// Top ten songs

	public List<Song> findTopTen() {
		return songRepository.findTop10ByOrderByRatingDesc();

	}
}

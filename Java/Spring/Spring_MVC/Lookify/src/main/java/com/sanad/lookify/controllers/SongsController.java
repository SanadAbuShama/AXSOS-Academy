package com.sanad.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanad.lookify.models.Song;
import com.sanad.lookify.services.SongService;

@Controller
public class SongsController {
	private final SongService songService;

	public SongsController(SongService songService) {
		this.songService = songService;
	}

	@GetMapping("/")
	public String home() {

		return "/songs/home.jsp";
	}

	@GetMapping("/dashboard")
	public String index(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/songs/index.jsp";
	}

	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {

		return "/songs/new.jsp";
	}

	@GetMapping("/songs/topTen")
	public String topTen(Model model) {
		model.addAttribute("songs", songService.findTopTen());
		return "/songs/topTen.jsp";
	}

	@PostMapping("/songs")
	public String create(Model model, @Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			List<Song> songs = songService.allSongs();
			model.addAttribute("songs", songs);
			return "/songs/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/songs/{id}")
	public String index(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/songs/songDetails.jsp";
	}

	@DeleteMapping("/songs/{id}")
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}

	@GetMapping("/search")
	public String search(@RequestParam("search") String searchQuery, Model model) {
		List<Song> songs = songService.findByArtist(searchQuery);
		model.addAttribute("songs", songs);
		model.addAttribute("query", searchQuery);
		return "/songs/search.jsp";
	}

	@GetMapping("/songs/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Song lang = songService.findSong(id);
		model.addAttribute("song", lang);
		return "/songs/edit.jsp";
	}

	@PutMapping("/songs/edit/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/songs/edit.jsp";
		} else {
			songService.updateSong(id, song);
			return "redirect:/songs";
		}

	}

//
}

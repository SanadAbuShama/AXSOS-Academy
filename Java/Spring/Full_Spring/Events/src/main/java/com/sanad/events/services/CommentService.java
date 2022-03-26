package com.sanad.events.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanad.events.models.Comment;
import com.sanad.events.models.EventM;
import com.sanad.events.models.User;
import com.sanad.events.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private UserService userServ;

	@Autowired
	private EventService eventServ;

	public void addComment(Long eventId, Long userId, Comment newComment) {

		User loggedUser = userServ.findUserById(userId);
		EventM event = eventServ.findEventById(eventId);
		newComment.setId(null);
		newComment.setCommenter(loggedUser);
		newComment.setEvent(event);
		commentRepo.save(newComment);
	}

}
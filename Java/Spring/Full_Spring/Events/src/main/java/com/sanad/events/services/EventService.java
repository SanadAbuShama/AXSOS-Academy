package com.sanad.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanad.events.models.EventM;
import com.sanad.events.models.User;
import com.sanad.events.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepo;

	@Autowired
	private UserService userServ;

	public List<EventM> eventsInState(String state) {

		return eventRepo.findByStateIs(state);
	}

	public List<EventM> eventsInOtherStates(String state) {

		return eventRepo.findByStateNot(state);
	}

	public void createEvent(EventM newEvent, User loggedUser) {
		newEvent.setCreator(loggedUser);
		eventRepo.save(newEvent);
	}

	public EventM findEventById(Long id) {
		Optional<EventM> e = eventRepo.findById(id);
		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}

	public void joinEvent(Long eventId, Long userId) {
		EventM event = this.findEventById(eventId);
		User loggedUser = userServ.findUserById(userId);
		event.getAttendees().add(loggedUser);
		eventRepo.save(event);
	}

	public void cancelEvent(Long eventId, Long userId) {
		EventM event = this.findEventById(eventId);
		User loggedUser = userServ.findUserById(userId);
		event.getAttendees().remove(loggedUser);
		eventRepo.save(event);
	}

	public void updateEvent(Long eventId, EventM updatedEvent) {
		EventM event = this.findEventById(eventId);
		event.setName(updatedEvent.getName());
		event.setDate(updatedEvent.getDate());
		event.setLocation(updatedEvent.getLocation());
		event.setState(updatedEvent.getState());
		eventRepo.save(event);
	}

	public void deleteEvent(Long eventId) {
		EventM event = this.findEventById(eventId);
		eventRepo.delete(event);
	}

}
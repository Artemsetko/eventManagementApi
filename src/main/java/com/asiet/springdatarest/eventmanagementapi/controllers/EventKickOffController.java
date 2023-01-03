package com.asiet.springdatarest.eventmanagementapi.controllers;

import com.asiet.springdatarest.eventmanagementapi.entities.Event;
import com.asiet.springdatarest.eventmanagementapi.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventKickOffController {

	@Autowired
	private EventRepository eventRepository;

	@PostMapping("/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		Optional<Event> event = eventRepository.findById(id);

		if (event.isEmpty()) {
			throw new ResourceNotFoundException("Resource Not Found");
		}
		event.get().setStarted(true);
		eventRepository.save(event.get());

		return ResponseEntity.ok(event.get().getName() + " has started");
	}

}

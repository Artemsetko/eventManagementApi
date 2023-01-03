package com.asiet.springdatarest.eventmanagementapi.controllers;

import com.asiet.springdatarest.eventmanagementapi.controllers.exceptions.NotCheckedInException;
import com.asiet.springdatarest.eventmanagementapi.entities.Participant;
import com.asiet.springdatarest.eventmanagementapi.repos.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RepositoryRestController
public class CheckOutController {

	@Autowired
	private ParticipantRepository participantRepository;

	@PostMapping("events/checkout/{id}")
	public ResponseEntity<PersistentEntityResource> checkout(@PathVariable Long id,PersistentEntityResourceAssembler assembler) {

		Optional<Participant> participant = participantRepository.findById(id);

		if (participant.isPresent()) {
			if (!participant.get().getCheckedIn()) {
				throw new NotCheckedInException();
			}
		}
		participant.get().setCheckedIn(false);
		participantRepository.save(participant.get());

		return ResponseEntity.ok(assembler.toFullResource(participant.get()));

	}
}

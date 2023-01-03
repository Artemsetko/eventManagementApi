package com.asiet.springdatarest.eventmanagementapi.controllers;

import com.asiet.springdatarest.eventmanagementapi.controllers.exceptions.AlreadyCheckedInException;
import com.asiet.springdatarest.eventmanagementapi.entities.Participant;
import com.asiet.springdatarest.eventmanagementapi.repos.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@RepositoryRestController
public class CheckInController {

	@Autowired
	private ParticipantRepository participantRepository;

	@PostMapping("events/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {

		Optional<Participant> participant = participantRepository.findById(id);

		if (participant.isPresent()) {
			if (participant.get().getCheckedIn()) {
				throw new AlreadyCheckedInException("AlreadyCheckIN");
			}
		}
		participant.get().setCheckedIn(true);
		participantRepository.save(participant.get());

		return ResponseEntity.ok(assembler.toFullResource(participant.get()));

	}
}

package com.asiet.springdatarest.eventmanagementapi.repos;

import com.asiet.springdatarest.eventmanagementapi.entities.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long>, CrudRepository<Participant, Long> {


}
package com.asiet.springdatarest.eventmanagementapi.repos;

import com.asiet.springdatarest.eventmanagementapi.entities.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long>, CrudRepository<Organizer, Long> {


}
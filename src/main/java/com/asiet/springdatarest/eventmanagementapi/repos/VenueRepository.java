package com.asiet.springdatarest.eventmanagementapi.repos;

import com.asiet.springdatarest.eventmanagementapi.entities.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VenueRepository extends PagingAndSortingRepository<Venue, Long>, CrudRepository<Venue, Long> {


}
package com.asiet.springdatarest.eventmanagementapi.repos;

import com.asiet.springdatarest.eventmanagementapi.entities.Event;
import com.asiet.springdatarest.eventmanagementapi.entities.projections.PartialEventProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.ZoneId;

@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long>, CrudRepository<Event, Long> {
    Page<Event> findByName(@Param("name") String name, Pageable pageable);
    Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable);
}


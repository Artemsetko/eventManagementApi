package com.asiet.springdatarest.eventmanagementapi.entities.projections;


import com.asiet.springdatarest.eventmanagementapi.entities.Event;
import org.springframework.data.rest.core.config.Projection;

import java.time.Instant;
import java.time.ZonedDateTime;


@Projection(name = "partial", types = { Event.class })
public interface PartialEventProjection {

	String getName();

	ZonedDateTime getStartTime();

	ZonedDateTime getEndTime();
	
	Instant getCreated();
}

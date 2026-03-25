package org.daypilot.demo.html5eventcalendarspring.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.daypilot.demo.html5eventcalendarspring.Entity.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public interface EventRepository extends CrudRepository<Event, Long>{
	@Query("from Event e where not(e.end < :from or e.start > :to)")
	public List<Event> findBetween(@Param("from") @DateTimeFormat(iso=ISO.DATE_TIME) LocalDateTime start, @Param("to") @DateTimeFormat(iso=ISO.DATE_TIME) LocalDateTime end);

	
	@Query("""
	SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END
	FROM Event e
	WHERE 
		(:excludeId IS NULL OR e.id <> :excludeId)
		AND e.start < :end
		AND e.end > :start
	""")
	boolean existsOverlapping(
		@Param("start") LocalDateTime start,
		@Param("end") LocalDateTime end,
		@Param("excludeId") Long excludeId
	);

	@Query("""
	SELECT e FROM Event e
	WHERE e.start < :end
	AND e.end > :start
	""")
	List<Event> findOverlapping(LocalDateTime start, LocalDateTime end);

}
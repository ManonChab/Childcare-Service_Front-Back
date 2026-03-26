
package org.daypilot.demo.html5eventcalendarspring.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import jakarta.annotation.security.PermitAll;

import org.daypilot.demo.html5eventcalendarspring.Entity.Event;
import org.daypilot.demo.html5eventcalendarspring.Entity.EventStatus;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.EventRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.EventResponseDTO;
import org.daypilot.demo.html5eventcalendarspring.repository.EventRepository;
import org.daypilot.demo.html5eventcalendarspring.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class CalendarController {
    private final EventService eventService;

    public CalendarController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping
    @PermitAll
    public EventResponseDTO create(
        @RequestBody EventRequestDTO dto,
        Authentication auth
    ) {
    // 🔹 Debug log to see if auth is null
    System.out.println("AUTH: " + auth);
    
    // Optional: log the DTO
    System.out.println("DTO: " + dto);

    return eventService.create(dto, auth);
}
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<EventResponseDTO> getAll() {
        return eventService.getAllEvents();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/approve")
    public Event approve(@PathVariable Long id) {
        return eventService.approve(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/reject")
    public Event reject(@PathVariable Long id) {
        return eventService.reject(id);
    }

    
    // @PostMapping
    // @PermitAll
    // public EventResponseDTO create(
    //     @RequestBody EventRequestDTO dto,
    //     Authentication auth
    // ) {
    //     return eventService.create(dto, auth);
    // }
    
    
    
}
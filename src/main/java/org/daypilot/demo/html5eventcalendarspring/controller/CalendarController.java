
package org.daypilot.demo.html5eventcalendarspring.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import org.daypilot.demo.html5eventcalendarspring.Entity.Event;
import org.daypilot.demo.html5eventcalendarspring.Entity.EventStatus;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.EventRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.EventResponseDTO;
import org.daypilot.demo.html5eventcalendarspring.repository.EventRepository;
import org.daypilot.demo.html5eventcalendarspring.service.EventService;
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

    @PostMapping
    public EventResponseDTO create(
        @RequestBody EventRequestDTO dto,
        Authentication auth
    ) {
        return eventService.create(dto, auth);
    }
}
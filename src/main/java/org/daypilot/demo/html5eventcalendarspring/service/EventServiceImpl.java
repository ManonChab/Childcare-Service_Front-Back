package org.daypilot.demo.html5eventcalendarspring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.StreamSupport;

import org.daypilot.demo.html5eventcalendarspring.Entity.Event;
import org.daypilot.demo.html5eventcalendarspring.Entity.EventStatus;
import org.daypilot.demo.html5eventcalendarspring.Entity.User;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.EventRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.EventResponseDTO;
import org.daypilot.demo.html5eventcalendarspring.mappper.EventMapper;
import org.daypilot.demo.html5eventcalendarspring.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository er;

    private final EventMapper mapper;
    
    public EventServiceImpl(EventRepository er, EventMapper mapper) {
    this.er = er;
    this.mapper = mapper;
}

    public List<EventResponseDTO> getAllEvents() {
        return ((List<Event>) er.findAll())
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
}

    public Event approve(Long id) {
        Event e = er.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found"));

        e.setStatus(EventStatus.ACCEPTED);
        return er.save(e);
    }

    public Event reject(Long id) {
        Event e = er.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found"));

        e.setStatus(EventStatus.REJECTED);
        return er.save(e);
    }

    public EventResponseDTO create(EventRequestDTO dto, Authentication auth) {

    User user = (User) auth.getPrincipal();

    Event e = mapper.toEntity(dto);

    e.setUser(user);
    e.setStatus(EventStatus.REQUESTED);

    validateSlot(e.getStart(), e.getEnd());

    Event saved = er.save(e);

    return mapper.toResponseDTO(saved);
    }

    private void validateSlot(LocalDateTime start, LocalDateTime end) {
    List<Event> overlaps = StreamSupport.stream(er.findAll().spliterator(), false)
        .filter(e -> e.getStatus() == EventStatus.REQUESTED || e.getStatus() == EventStatus.ACCEPTED)
        .filter(e -> start.isBefore(e.getEnd()) && end.isAfter(e.getStart()))
        .toList();

    if (!overlaps.isEmpty()) {
        throw new RuntimeException("Slot already taken for REQUESTED or ACCEPTED events");
    }
}

}


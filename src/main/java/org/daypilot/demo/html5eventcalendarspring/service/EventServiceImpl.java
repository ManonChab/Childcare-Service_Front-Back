package org.daypilot.demo.html5eventcalendarspring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.daypilot.demo.html5eventcalendarspring.Entity.Event;
import org.daypilot.demo.html5eventcalendarspring.Entity.EventStatus;
import org.daypilot.demo.html5eventcalendarspring.Entity.User;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.EventRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.EventResponseDTO;
import org.daypilot.demo.html5eventcalendarspring.mappper.EventMapper;
import org.daypilot.demo.html5eventcalendarspring.repository.EventRepository;
import org.daypilot.demo.html5eventcalendarspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository er;
    private UserRepository userRepository;

    private final EventMapper mapper;
    
    public EventServiceImpl(EventRepository er, EventMapper mapper, UserRepository userRepository) {
    this.er = er;
    this.mapper = mapper;
    this.userRepository=userRepository;
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

    @Override
public EventResponseDTO create(EventRequestDTO dto, Authentication auth) {
    User user;

    // SAFE: do NOT call auth.getName() if auth is null
    if (auth != null) {
        try {
            String email = auth.getName(); 
            user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        } catch (Exception e) {
            // fallback if something goes wrong
            user = userRepository.findById(dto.userId() != null ? dto.userId() : 1)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }
    } else {
        // TEMPORARY fallback: no auth provided
        user = userRepository.findById(dto.userId() != null ? dto.userId() : 1)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    Event event = mapper.toEntity(dto);
    event.setUser(user);

    if (event.getStatus() == null) {
        event.setStatus(EventStatus.REQUESTED);
    }

    Event savedEvent = er.save(event);
    return mapper.toResponseDTO(savedEvent);
}

    @Override
    public void deleteEvent(Long id) {
        Optional <Event> optionalEvent = er.findById(id);
        if (optionalEvent.isEmpty())
            throw new RuntimeException("The slot does not exist");
        er.delete(optionalEvent.get());
    }

}


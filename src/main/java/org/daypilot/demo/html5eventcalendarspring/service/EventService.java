package org.daypilot.demo.html5eventcalendarspring.service;

import java.util.List;

import org.daypilot.demo.html5eventcalendarspring.Entity.Event;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.EventRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.EventResponseDTO;
import org.springframework.security.core.Authentication;

public interface EventService {

    public List<EventResponseDTO> getAllEvents();

    public Event approve(Long id);

    public Event reject(Long id);

    public EventResponseDTO create(EventRequestDTO dto, Authentication auth);;

}

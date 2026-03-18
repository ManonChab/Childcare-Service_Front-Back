package org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

import org.daypilot.demo.html5eventcalendarspring.Entity.Child;
import org.daypilot.demo.html5eventcalendarspring.Entity.User;

public record EventResponseDTO(
    String text,
    LocalDateTime start,
    LocalDateTime end,
    String color,
    User user, 
    List<Child> children
) {

}

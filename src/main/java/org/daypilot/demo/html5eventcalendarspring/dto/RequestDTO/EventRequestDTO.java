package org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO;

import java.time.LocalDateTime;
import java.util.List;

import org.daypilot.demo.html5eventcalendarspring.Entity.Child;
import org.daypilot.demo.html5eventcalendarspring.Entity.User;

public record EventRequestDTO(
    Long id,
    String text,
    LocalDateTime start,
    LocalDateTime end,
    String color,
    User user, 
    List<Child> children
) {

}

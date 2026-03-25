package org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO;

import java.time.LocalDateTime;
import java.util.List;

import org.daypilot.demo.html5eventcalendarspring.Entity.User;

public record EventRequestDTO(
    String text,
    LocalDateTime start,
    LocalDateTime end
) {

}

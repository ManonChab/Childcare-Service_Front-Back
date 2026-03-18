package org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO;

import java.util.List;

import org.daypilot.demo.html5eventcalendarspring.Entity.Child;
import org.daypilot.demo.html5eventcalendarspring.Entity.Event;

public record UserRequestDTO(
    Integer id,
    String name,
    String lastName,
    String email,
    String password,
    String address, 
    String color,
    List<Event> events,
    List<Child> children
) {

}

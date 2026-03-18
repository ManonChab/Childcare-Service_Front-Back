
package org.daypilot.demo.html5eventcalendarspring.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import org.daypilot.demo.html5eventcalendarspring.Entity.Event;
import org.daypilot.demo.html5eventcalendarspring.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@RestController
public class CalendarController {

    @Autowired
    EventRepository er;

    @RequestMapping("/api")
    @ResponseBody
    String home() {
        return "Welcome!";
    }

    @GetMapping("/api/events")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    Iterable<Event> events(@RequestParam("start") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime start, @RequestParam("end") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime end) {
        return er.findBetween(start, end);
    }

    @PostMapping("/api/events/create")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    public Event createEvent(@RequestBody EventCreateParams params) {

    validateSlot(params.start, params.end, null);

    Event e = new Event();
    e.setStart(params.start);
    e.setEnd(params.end);
    e.setText(params.text);

    er.save(e);

    return e;
}

    @PostMapping("/api/events/move")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    Event moveEvent(@RequestBody EventMoveParams params) {

        Event e = er.findById(params.id).get();

        e.setStart(params.start);
        e.setEnd(params.end);

        er.save(e);

        return e;
    }

    @PostMapping("/api/events/setColor")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    Event setColor(@RequestBody SetColorParams params) {

        Event e = er.findById(params.id).get();
        e.setColor(params.color);
        er.save(e);

        return e;
    }

    public static class EventCreateParams {
        public LocalDateTime start;
        public LocalDateTime end;
        public String text;
        public Long resource;
    }

    public static class EventMoveParams {
        public Long id;
        public LocalDateTime start;
        public LocalDateTime end;
        public Long resource;
    }

    public static class SetColorParams {
        public Long id;
        public String color;
    }

    @PostMapping("/api/events/update")
@Transactional
public Event updateEvent(@RequestBody EventUpdateParams params) {

    Event e = er.findById(params.id)
        .orElseThrow(() -> new RuntimeException("Event not found"));

    validateSlot(params.start, params.end, params.id);

    e.setText(params.text);
    e.setStart(params.start);
    e.setEnd(params.end);

    er.save(e);

    return e;
}

private void validateSlot(LocalDateTime start, LocalDateTime end, Long excludeId) {

    // Rule 1: End must be after start
    if (end.isBefore(start) || end.equals(start)) {
        throw new RuntimeException("End must be after start");
    }

    // Rule 2: No past bookings
    if (start.isBefore(LocalDateTime.now())) {
        throw new RuntimeException("Cannot create slot in the past");
    }

    // Rule 3: No overlap
    boolean overlaps = er.existsOverlapping(start, end, excludeId);

    if (overlaps) {
        throw new RuntimeException("Slot overlaps with an existing one");
    }
}

public static class EventUpdateParams {
    public Long id;
    public LocalDateTime start;
    public LocalDateTime end;
    public String text;
}

@DeleteMapping("/api/events/{id}")
@Transactional
public void deleteEvent(@PathVariable Long id) {
    er.deleteById(id);
}

}
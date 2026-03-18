package org.daypilot.demo.html5eventcalendarspring.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "text")
    String text;

    @Column(name = "event_start")
    LocalDateTime start;

    @Column(name = "event_end")
    LocalDateTime end;

    @Column(name = "color")
    String color;

@ManyToOne
@JoinColumn(name = "user_id")
    User user;

@ManyToMany
@JsonIgnore
@JoinTable(name = "event_child", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "child_id"))
    List<Child> children;
}

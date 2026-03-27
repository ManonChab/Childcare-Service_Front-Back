package org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record EventRequestDTO(
    String text,
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime start,
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime end,
    Integer userId
) {}

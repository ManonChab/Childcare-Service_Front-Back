package org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO;

import java.time.LocalDateTime;

public record EventResponseDTO(
    Long id,
    String text,
    LocalDateTime start,
    LocalDateTime end,
    String status,
    UserBasicDTO user
) {}

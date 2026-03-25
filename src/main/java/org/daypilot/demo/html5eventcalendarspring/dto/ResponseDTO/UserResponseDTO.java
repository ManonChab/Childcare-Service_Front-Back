package org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO;

public record UserResponseDTO(
    Integer id,
    String firstName,
    String lastName,
    String email,
    String phone,
    String address, 
    String color,
    Integer childrenCount
) {

}

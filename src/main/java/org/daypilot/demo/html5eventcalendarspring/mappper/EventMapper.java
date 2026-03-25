package org.daypilot.demo.html5eventcalendarspring.mappper;

import org.daypilot.demo.html5eventcalendarspring.Entity.Event;
import org.daypilot.demo.html5eventcalendarspring.Entity.User;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.EventRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.EventResponseDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.UserBasicDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel ="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    Event toEntity (EventRequestDTO dto);

    

    default EventResponseDTO toResponseDTO(Event event) {
        UserBasicDTO userDto = null;
        if (event.getUser() != null) {
            userDto = new UserBasicDTO(event.getUser().getId(), event.getUser().getFirstName());
        }
        

        String status = event.getStatus() != null ? event.getStatus().name() : "UNKNOWN";
        return new EventResponseDTO(
            event.getId(),
            event.getText(),
            event.getStart(),
            event.getEnd(),
            status,
            userDto
        );
        
    }
    

    UserBasicDTO toUserSummaryDTO(User user);

}



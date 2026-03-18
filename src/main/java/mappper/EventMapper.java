package mappper;

import org.daypilot.demo.html5eventcalendarspring.Entity.Event;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.EventRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.EventResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel ="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    Event toEntity (EventRequestDTO dto);

    EventResponseDTO toResponseDTO (Event event);

}

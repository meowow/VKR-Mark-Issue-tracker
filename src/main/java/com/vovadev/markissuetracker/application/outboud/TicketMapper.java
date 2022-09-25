package com.vovadev.markissuetracker.application.outboud;

import com.vovadev.markissuetracker.aggregate.Ticket;
import com.vovadev.markissuetracker.application.model.TicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TicketMapper {
  @Mapping(source = "title", target = "title")
  @Mapping(source = "body", target = "body")
  @Mapping(source = "priority", target = "priority")
  @Mapping(source = "type", target = "type")
  @Mapping(target = "departmentId", ignore = true)
  @Mapping(target = "reporterId", ignore = true)
  @Mapping(target = "workerId", ignore = true)
  TicketDto toTicketDto(Ticket ticket);
}

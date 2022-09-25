package com.vovadev.markissuetracker.application.inboud.service;

import com.vovadev.markissuetracker.application.model.TicketDto;
import com.vovadev.markissuetracker.application.valueobject.Priority;

public interface TicketService {
  TicketDto createTicket(
      Long departmentId,
      Long reporterId,
      Long workerId,
      String title,
      String body,
      Priority priority,
      Priority type);
}

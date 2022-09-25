package com.vovadev.markissuetracker.application;

import com.vovadev.markissuetracker.aggregate.Ticket;
import com.vovadev.markissuetracker.application.inboud.service.TicketService;
import com.vovadev.markissuetracker.application.model.TicketDto;
import com.vovadev.markissuetracker.application.valueobject.Priority;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TicketServiceImpl implements TicketService {
  @Transactional
  @Override
  public TicketDto createTicket(
      Long departmentId,
      Long reporterId,
      Long workerId,
      String title,
      String body,
      Priority priority,
      Priority type) {
    var ticket = Ticket.create(departmentId, reporterId, workerId, title, body, priority, type);

    return null;
  }
}

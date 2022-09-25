package com.vovadev.markissuetracker.application.inboud.service;

import com.vovadev.markissuetracker.application.model.CreateTicketRequest;
import com.vovadev.markissuetracker.application.model.TicketDto;

public interface TicketService {
  TicketDto createTicket(CreateTicketRequest req);
}

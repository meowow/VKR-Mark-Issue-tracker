package com.vovadev.markissuetracker.dapter.inbound;

import com.vovadev.markissuetracker.application.inboud.service.TicketService;
import com.vovadev.markissuetracker.application.model.CreateTicketRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

  private final TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @PostMapping
  public Long createTicket(CreateTicketRequest req) {
    var createdTicket = ticketService.createTicket(req);
    return createdTicket.id();
  }
}

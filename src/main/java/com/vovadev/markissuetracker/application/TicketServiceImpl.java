package com.vovadev.markissuetracker.application;

import com.vovadev.markissuetracker.aggregate.Ticket;
import com.vovadev.markissuetracker.application.inboud.service.TicketService;
import com.vovadev.markissuetracker.application.model.CreateTicketRequest;
import com.vovadev.markissuetracker.application.model.TicketDto;
import com.vovadev.markissuetracker.application.outboud.TicketMapper;
import com.vovadev.markissuetracker.application.outboud.TicketRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TicketServiceImpl implements TicketService {

  private final TicketMapper ticketMapper;
  private final TicketRepository ticketRepository;

  public TicketServiceImpl(TicketMapper ticketMapper, TicketRepository ticketRepository) {
    this.ticketMapper = ticketMapper;
    this.ticketRepository = ticketRepository;
  }

  @Transactional
  @Override
  public TicketDto createTicket(CreateTicketRequest req) {

    // check for department

    // check for reporter

    // check for worker

    var ticket =
        Ticket.create(
            req.departmentId(),
            req.reporterId(),
            req.workerId(),
            req.title(),
            req.body(),
            req.priority(),
            req.type());
    var savedTicket = ticketRepository.save(ticket);
    return ticketMapper.toTicketDto(savedTicket);
  }
}

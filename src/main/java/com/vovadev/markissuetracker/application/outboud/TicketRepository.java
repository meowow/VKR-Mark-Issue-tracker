package com.vovadev.markissuetracker.application.outboud;

import com.vovadev.markissuetracker.aggregate.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}

package com.vovadev.markissuetracker.application;

import com.vovadev.markissuetracker.application.inboud.service.TicketService;
import com.vovadev.markissuetracker.application.model.CreateTicketRequest;
import com.vovadev.markissuetracker.application.outboud.TicketMapperImpl;
import com.vovadev.markissuetracker.application.outboud.TicketRepository;
import com.vovadev.markissuetracker.application.valueobject.Priority;
import com.vovadev.markissuetracker.application.valueobject.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TicketServiceImplTest {
  @Autowired TicketRepository ticketRepository;
  @Autowired TicketService ticketService;

  @Test
  void create_ticket() {
    // given

    // when
    var result =
        ticketService.createTicket(
            new CreateTicketRequest(
                1L, 1L, 1L, "New Ticket", "This is a body", Priority.MEDIUM, Type.BUG));
    // then
    assertThat(result.title()).isEqualTo("New Ticket");
    assertThat(result.body()).isEqualTo("This is a body");
    assertThat(result.priority()).isEqualTo(Priority.MEDIUM);
    assertThat(result.type()).isEqualTo(Type.BUG);
  }

  @TestConfiguration
  static class LocalConfiguration {

    @Bean
    public TicketService ticketService(TicketRepository ticketRepository) {
      return new TicketServiceImpl(new TicketMapperImpl(), ticketRepository);
    }
  }
}

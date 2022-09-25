package com.vovadev.markissuetracker.aggregate;

import com.vovadev.markissuetracker.application.valueobject.Priority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.Instant;

/**
 * Аггрегат заявки инкапсулирующий бизнесс-логику её жизненного цикла. Так-же является Сущностью в
 * базе данных
 */
@Entity
@Table(name = "ticket")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {
  public Ticket() {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  /** Индентификатор департамента */
  Long departmentId;
  /** Идентификатор пользователя создавшего заявку */
  Long reporterId;

  /** Идентификатор рабочего на кого создана заявка */
  Long workerId;
  /** Заголовок заявки */
  String title;

  /** Тело заявки */
  String body;

  @Enumerated Priority priority;

  @Enumerated Priority type;

  @Version Long version;
  Instant created;

  Instant updated;

  /**
   * Метод создание новой заявки
   *
   * @param departmentId Индентификатор департамента
   * @param reporterId Идентификатор пользователя создавшего заявку
   * @param workerId Идентификатор рабочего на кого создана заявка
   * @param title Заголовок заявки
   * @param body Тело заявки
   * @param priority Приоритет заявки
   * @param type Тип заявки
   * @return Ticket Возвращает новую заявку
   */
  public static Ticket create(
      Long departmentId,
      Long reporterId,
      Long workerId,
      String title,
      String body,
      Priority priority,
      Priority type) {

    var now = Instant.now();

    return Ticket.builder()
        .departmentId(departmentId)
        .reporterId(reporterId)
        .workerId(workerId)
        .title(title)
        .body(body)
        .priority(priority)
        .type(type)
        .created(now)
        .updated(now)
        .build();
  }
}

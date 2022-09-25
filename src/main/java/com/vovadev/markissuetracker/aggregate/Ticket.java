package com.vovadev.markissuetracker.aggregate;

import com.vovadev.markissuetracker.application.valueobject.Priority;
import com.vovadev.markissuetracker.application.valueobject.Type;

import javax.persistence.*;
import java.time.Instant;

/**
 * Аггрегат заявки инкапсулирующий бизнесс-логику её жизненного цикла. Так-же является Сущностью в
 * базе данных
 */
@Entity
@Table(name = "ticket")
public class Ticket {
  public Ticket() {}

  public Ticket(
      Long departmentId,
      Long reporterId,
      Long workerId,
      String title,
      String body,
      Priority priority,
      Type type,
      Instant created,
      Instant updated) {
    this.departmentId = departmentId;
    this.reporterId = reporterId;
    this.workerId = workerId;
    this.title = title;
    this.body = body;
    this.priority = priority;
    this.type = type;
    this.created = created;
    this.updated = updated;
  }

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

  @Enumerated Type type;

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
      Type type) {

    var now = Instant.now();

    return new Ticket(departmentId, reporterId, workerId, title, body, priority, type, now, now);
  }

  public Long getId() {
    return id;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public Long getReporterId() {
    return reporterId;
  }

  public Long getWorkerId() {
    return workerId;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public Priority getPriority() {
    return priority;
  }

  public Type getType() {
    return type;
  }

  public Long getVersion() {
    return version;
  }

  public Instant getCreated() {
    return created;
  }

  public Instant getUpdated() {
    return updated;
  }
}

package com.vovadev.markissuetracker.application.model;

import com.vovadev.markissuetracker.application.valueobject.Priority;
import com.vovadev.markissuetracker.application.valueobject.Type;

public record CreateTicketRequest(
        Long departmentId,
        Long reporterId,
        Long workerId,
        String title,
        String body,
        Priority priority,
        Type type
) {
}

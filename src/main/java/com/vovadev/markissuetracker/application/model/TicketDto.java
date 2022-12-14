package com.vovadev.markissuetracker.application.model;

import com.vovadev.markissuetracker.application.valueobject.Priority;
import com.vovadev.markissuetracker.application.valueobject.Type;

public record TicketDto(
        Long id,
        DepartmentDto departmentId,
        UserDto reporterId,
        UserDto workerId,
        String title,
        String body,
        Priority priority,
        Type type
) {
}

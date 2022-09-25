package com.vovadev.markissuetracker.application.model;

import com.vovadev.markissuetracker.application.valueobject.Priority;

public record TicketDto(
        DepartmentDto departmentId,
        UserDto reporterId,
        UserDto workerId,
        String title,
        String body,
        Priority priority,
        Priority type
) {
}

package com.company.vehicle_management.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ApiErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        List<String> messages,
        String path
) {}


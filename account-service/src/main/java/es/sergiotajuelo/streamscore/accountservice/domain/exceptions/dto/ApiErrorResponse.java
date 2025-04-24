package es.sergiotajuelo.streamscore.accountservice.domain.exceptions.dto;

import lombok.Builder;

@Builder
public record ApiErrorResponse(
        String timestamp,
        int status,
        String error,
        String message,
        String path
) {}

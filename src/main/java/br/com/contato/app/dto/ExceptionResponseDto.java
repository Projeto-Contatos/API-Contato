package br.com.contato.app.dto;

import java.util.Map;

public record ExceptionResponseDto(
        String message,
        Map<String, String> erros
) {
    public ExceptionResponseDto {
        erros = erros != null ? erros : Map.of();
    }
}
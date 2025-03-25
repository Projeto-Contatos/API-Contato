package br.com.contato.app.dto.contato;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record ContatoResponseDto(
        @NotBlank(message = "This field cannot be null or blank!")
        Integer id,

        @NotBlank(message = "This field cannot be null or blank!")
        String nome,

        @NotBlank(message = "This field cannot be null or blank!")
        @Pattern(regexp = "^[A-Za-z0-9+_.-]{1,20}@[A-Za-z0-9.-]{1,20}\\.[A-Za-z]{2,10}$", message = "Must be an email pattern.")
        String email,

        @NotBlank(message = "This field cannot be null or blank!")
        String celular,

        @NotBlank(message = "This field cannot be null or blank!")
        String telefone,

        @NotBlank(message = "This field cannot be null or blank!")
        Character favorito,

        @NotBlank(message = "This field cannot be null or blank!")
        Character ativo,

        @NotBlank(message = "This field cannot be null or blank!")
        LocalDateTime cadastro
) {
}

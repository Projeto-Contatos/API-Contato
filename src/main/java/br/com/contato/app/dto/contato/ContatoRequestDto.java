package br.com.contato.app.dto.contato;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ContatoRequestDto(
        @NotBlank(message = "This field cannot be null or blank!")
        String nome,

        @NotBlank(message = "This field cannot be null or blank!")
        @Pattern(regexp = "^[A-Za-z0-9+_.-]{1,20}@[A-Za-z0-9.-]{1,20}\\.[A-Za-z]{2,10}$", message = "Must be an email pattern.")
        String email,

        @NotBlank(message = "This field cannot be null or blank!")
        String celular,

        @NotBlank(message = "This field cannot be null or blank!")
        String telefone,

        @Schema(hidden = true)
        @NotBlank(message = "This field cannot be null or blank!")
        Character favorito,

        @Schema(hidden = true)
        @NotBlank(message = "This field cannot be null or blank!")
        Character ativo
) {
}

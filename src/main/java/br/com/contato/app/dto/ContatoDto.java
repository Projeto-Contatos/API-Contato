package br.com.contato.app.dto;

import java.time.LocalDateTime;

public record ContatoDto(
        Integer id,
        String nome,
        String email,
        String celular,
        String telefone,
        Character favorito,
        Character ativo,
        LocalDateTime cadastro
) {
}

package br.com.contato.app.controllers;

import br.com.contato.app.dto.contato.ContatoRequestDto;
import br.com.contato.app.dto.contato.ContatoUpdateDto;
import br.com.contato.app.services.ContatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService contatoService;

    @PostMapping("/create")
    public ResponseEntity<ContatoRequestDto> saveContato(@RequestBody @Valid ContatoRequestDto contatoRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.createContato(contatoRequestDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ContatoRequestDto>> getAllContatos() {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findAll());
    }

    @PatchMapping("/favorito/{id}")
    public ResponseEntity<Void> toggleFavorito(@PathVariable Integer id) {
        contatoService.toggleFavorito(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/ativo/{id}")
    public ResponseEntity<Void> toggleAtivo(@PathVariable Integer id) {
        contatoService.toggleAtivo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContatoUpdateDto> updateContato(@PathVariable Integer id, @RequestBody ContatoUpdateDto contatoUpdateDto) {
        ContatoUpdateDto contatoAtualizado = contatoService.updateContato(id, contatoUpdateDto);
        return ResponseEntity.ok(contatoAtualizado);
    }
}

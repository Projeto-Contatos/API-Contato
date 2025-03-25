package br.com.contato.app.services;

import br.com.contato.app.dto.ContatoDto;
import br.com.contato.app.entity.ContatoEntity;
import br.com.contato.app.exceptions.CustomException;
import br.com.contato.app.mappers.ContatoMapper;
import br.com.contato.app.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoMapper contatoMapper;
    private final ContatoRepository contatoRepository;

    public ContatoDto createContato(ContatoDto contatoDto) {
        ContatoEntity contatoNew = contatoMapper.toModel(contatoDto);
        contatoRepository.save(contatoNew);

        return contatoMapper.toDto(contatoNew);
    }

    public List<ContatoDto> findAll() {
        List<ContatoEntity> contatos = contatoRepository.findAll();

        return contatoMapper.ListContatoDto(contatos);
    }

    public void toggleFavorito(Integer id) {
        ContatoEntity contato = contatoRepository.findById(id).orElseThrow(() -> {
            throw new CustomException("Contato não encontrado", HttpStatus.NOT_FOUND, null);
        });

        Character favoritoAtual = contato.getFavorito();
        Character novoValor = (favoritoAtual != null && favoritoAtual.equals('S')) ? 'N' : 'S';
        contato.setFavorito(novoValor);

        contatoRepository.save(contato);
    }

    public void toggleAtivo(Integer id) {
        ContatoEntity contato = contatoRepository.findById(id).orElseThrow(() -> {
            throw new CustomException("Contato não encontrado", HttpStatus.NOT_FOUND, null);
        });

        Character ativoAtual = contato.getAtivo();
        Character novoValorAtivo = (ativoAtual != null && ativoAtual.equals('S')) ? 'N' : 'S';
        contato.setAtivo(novoValorAtivo);

        contatoRepository.save(contato);
    }

    public ContatoDto updateContato(Integer id, ContatoDto contatoDto) {
        ContatoEntity contatoExistente = contatoRepository.findById(id).orElseThrow(() -> {
            throw new CustomException("Contato não encontrado", HttpStatus.NOT_FOUND, null);
        });

        contatoMapper.updateEntityFromDto(contatoDto, contatoExistente);
        contatoRepository.save(contatoExistente);

        return contatoMapper.toDto(contatoExistente);
    }
}

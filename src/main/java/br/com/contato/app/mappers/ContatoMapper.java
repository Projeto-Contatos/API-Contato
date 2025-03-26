package br.com.contato.app.mappers;

import br.com.contato.app.dto.contato.ContatoResponseDto;
import br.com.contato.app.dto.contato.ContatoRequestDto;
import br.com.contato.app.entity.ContatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContatoMapper {
    ContatoEntity toModel(ContatoRequestDto contatoRequestDto);
    ContatoRequestDto toDto(ContatoEntity contatoEntity);
    ContatoResponseDto toResponseDto(ContatoEntity entity);

    List<ContatoResponseDto> ListContatoDto(List<ContatoEntity> contatos);

    void updateEntityFromDto(ContatoRequestDto contatoRequestDto, @MappingTarget ContatoEntity contatoEntity);
}

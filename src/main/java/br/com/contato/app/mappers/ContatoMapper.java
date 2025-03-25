package br.com.contato.app.mappers;

import br.com.contato.app.dto.ContatoDto;
import br.com.contato.app.entity.ContatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContatoMapper {
    ContatoEntity toModel(ContatoDto contatoDto);
    ContatoDto toDto(ContatoEntity contatoEntity);

    List<ContatoDto> ListContatoDto(List<ContatoEntity> contatos);

    void updateEntityFromDto(ContatoDto contatoDto, @MappingTarget ContatoEntity contatoEntity);
}

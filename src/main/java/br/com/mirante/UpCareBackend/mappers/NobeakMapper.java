package br.com.mirante.UpCareBackend.mappers;

import br.com.mirante.UpCareBackend.dto.NobeakDTO;
import br.com.mirante.UpCareBackend.models.Nobeak;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NobeakMapper {
    NobeakMapper INSTANCE = Mappers.getMapper(NobeakMapper.class);

    NobeakDTO nobeakToNobeakDTO(Nobeak nobeak);

    Nobeak nobeakDTOToNobeak(NobeakDTO nobeakDTO);
}

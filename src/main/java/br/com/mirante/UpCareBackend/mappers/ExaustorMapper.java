package br.com.mirante.UpCareBackend.mappers;

import br.com.mirante.UpCareBackend.dto.ExaustorDTO;
import br.com.mirante.UpCareBackend.models.Exaustor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExaustorMapper {
    ExaustorMapper INSTANCE = Mappers.getMapper(ExaustorMapper.class);

    ExaustorDTO exaustorToExaustorDTO(Exaustor entity);

    Exaustor exaustorDTOToExaustor(ExaustorDTO dto);
}

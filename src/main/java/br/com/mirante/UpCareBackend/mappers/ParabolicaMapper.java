package br.com.mirante.UpCareBackend.mappers;

import br.com.mirante.UpCareBackend.dto.ParabolicaDTO;
import br.com.mirante.UpCareBackend.models.Parabolica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParabolicaMapper {
    ParabolicaMapper INSTANCE = Mappers.getMapper(ParabolicaMapper.class);

    ParabolicaDTO parabolicaToParabolicaDTO(Parabolica parabolica);

    Parabolica parabolicaDTOToParabolica(ParabolicaDTO parabolicaDTO);
}

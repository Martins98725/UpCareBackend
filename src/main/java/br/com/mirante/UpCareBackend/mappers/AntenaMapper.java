package br.com.mirante.UpCareBackend.mappers;

import br.com.mirante.UpCareBackend.dto.AntenaDTO;
import br.com.mirante.UpCareBackend.models.Antena;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AntenaMapper {
    AntenaMapper INSTANCE = Mappers.getMapper(AntenaMapper.class);

    AntenaDTO antenaToAntenaDTO(Antena antena);

    Antena antenaDTOToAntena(AntenaDTO antenaDTO);
}

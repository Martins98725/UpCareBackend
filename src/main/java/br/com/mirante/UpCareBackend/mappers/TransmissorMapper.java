package br.com.mirante.UpCareBackend.mappers;

import br.com.mirante.UpCareBackend.dto.TrasnmissorDTO;
import br.com.mirante.UpCareBackend.models.Transmissor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransmissorMapper {
    TransmissorMapper INSTANCE = Mappers.getMapper(TransmissorMapper.class);

    TrasnmissorDTO transmissorToTransmissorDTO(Transmissor transmissor);

    Transmissor transmissorDTOToTransmissor(TrasnmissorDTO trasnmissorDTO);
}

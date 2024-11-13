package br.com.mirante.UpCareBackend.mappers;

import br.com.mirante.UpCareBackend.dto.CombinadorDTO;
import br.com.mirante.UpCareBackend.models.Combinador;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CombinadorMapper {
    CombinadorMapper INSTANCE = Mappers.getMapper(CombinadorMapper.class);

    CombinadorDTO combinadorToCombinadorDTO(Combinador combinador);

    Combinador combinadorDTOToCombinador(CombinadorDTO combinadorDTO);
}

package br.com.mirante.UpCareBackend.mappers;

import br.com.mirante.UpCareBackend.dto.EstacaoDTO;
import br.com.mirante.UpCareBackend.models.Estacao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstacaoMapper {
    EstacaoMapper INSTANCE = Mappers.getMapper(EstacaoMapper.class);

    EstacaoDTO estacaoToEstacaoDTO(Estacao estacao);

    Estacao estacaoDTOToEstacao(EstacaoDTO estacaoDTO);
}

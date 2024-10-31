package br.com.mirante.UpCareBackend.service.Impl;

import br.com.mirante.UpCareBackend.dto.EstacaoDTO;
import br.com.mirante.UpCareBackend.dto.UsuarioDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.EstacaoMapper;
import br.com.mirante.UpCareBackend.models.Estacao;
import br.com.mirante.UpCareBackend.repository.EstacaoRepository;
import br.com.mirante.UpCareBackend.service.EstacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EstacaoServiceImpl implements EstacaoService {

    @Autowired
    private EstacaoRepository estacaoRepository;

    @Override
    public Page<Estacao> findAll(Pageable page, Specification<Estacao> spec) {
        return estacaoRepository.findAll(spec, page);
    }

    @Override
    public EstacaoDTO create(EstacaoDTO estacaoDTO) throws BusinessException {
        Estacao estacao = EstacaoMapper.INSTANCE.estacaoDTOToEstacao(estacaoDTO);

        if (estacaoRepository.existsById(estacao.getId())){
            throw new BusinessException("Estação ja existe");
        }

        estacao = estacaoRepository.save(estacao);

        return EstacaoMapper.INSTANCE.estacaoToEstacaoDTO(estacao);
    }

    @Override
    public Optional<EstacaoDTO> findById(UUID id) {
        return estacaoRepository.findById(id).map(EstacaoMapper.INSTANCE::estacaoToEstacaoDTO);
    }

    @Override
    public Optional<EstacaoDTO> update(EstacaoDTO estacaoDTO, UUID id) {
        if (estacaoRepository.existsById(id)){
            Estacao estacao = EstacaoMapper.INSTANCE.estacaoDTOToEstacao(estacaoDTO);
            estacao.setId(id);
            estacaoRepository.save(estacao);

            return Optional.of(EstacaoMapper.INSTANCE.estacaoToEstacaoDTO(estacao));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (estacaoRepository.existsById(id)){
            estacaoRepository.deleteById(id);

            return true;
        }
        return false;
    }
}

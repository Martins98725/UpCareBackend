package br.com.mirante.UpCareBackend.service;

import br.com.mirante.UpCareBackend.dto.EstacaoDTO;
import br.com.mirante.UpCareBackend.dto.UsuarioDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Estacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface EstacaoService {
    Page<Estacao> findAll(Pageable page, Specification<Estacao> spec);

    EstacaoDTO create(EstacaoDTO estacaoDTO) throws BusinessException;

    Optional<EstacaoDTO> findById(UUID id);

    Optional<EstacaoDTO> update(EstacaoDTO estacaoDTO, UUID id);

    boolean delete(UUID id);
}


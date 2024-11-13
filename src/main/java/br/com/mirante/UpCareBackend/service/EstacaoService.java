package br.com.mirante.UpCareBackend.service;

import br.com.mirante.UpCareBackend.dto.EstacaoDTO;
import br.com.mirante.UpCareBackend.dto.EstacaoDTOGet;
import br.com.mirante.UpCareBackend.dto.EstacaoDTOPost;
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

    EstacaoDTOPost create(EstacaoDTOPost estacaoDTO) throws BusinessException;

    Optional<EstacaoDTOGet> findById(UUID id);

    Optional<EstacaoDTO> update(EstacaoDTO estacaoDTO, UUID id);

    boolean delete(UUID id);
}


package br.com.mirante.UpCareBackend.service;

import br.com.mirante.UpCareBackend.dto.CombinadorDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Combinador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface CombinadorService {
    Page<Combinador> findAll(Pageable page, Specification<Combinador> spec);

    CombinadorDTO save(CombinadorDTO combinadorDTO) throws BusinessException;

    Optional<CombinadorDTO> findById(UUID id);

    Optional<CombinadorDTO> update(CombinadorDTO combinadorDTO, UUID id);

    boolean delete(UUID id);
}

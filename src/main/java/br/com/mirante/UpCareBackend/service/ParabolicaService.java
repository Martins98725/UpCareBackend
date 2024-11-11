package br.com.mirante.UpCareBackend.service;

import br.com.mirante.UpCareBackend.dto.ParabolicaDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Parabolica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ParabolicaService {
    Page<Parabolica> findAll(Pageable page, Specification<Parabolica> specification);

    ParabolicaDTO save(ParabolicaDTO trasnmissorDTO) throws BusinessException;

    Optional<ParabolicaDTO> findById(UUID id);

    Optional<ParabolicaDTO> update(UUID id, ParabolicaDTO trasnmissorDTO);

    boolean delete(UUID id);
}

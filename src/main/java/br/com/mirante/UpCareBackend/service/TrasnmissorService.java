package br.com.mirante.UpCareBackend.service;

import br.com.mirante.UpCareBackend.dto.TrasnmissorDTO;

import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Transmissor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface TrasnmissorService {
    Page<Transmissor> findAll(Pageable page, Specification<Transmissor> specification);

    TrasnmissorDTO save(TrasnmissorDTO trasnmissorDTO) throws BusinessException;

    Optional<TrasnmissorDTO> findById(UUID id);

    Optional<TrasnmissorDTO> update(UUID id, TrasnmissorDTO trasnmissorDTO);

    boolean delete(UUID id);
}

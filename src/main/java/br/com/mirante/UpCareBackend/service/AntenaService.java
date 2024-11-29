package br.com.mirante.UpCareBackend.service;

import br.com.mirante.UpCareBackend.dto.AntenaDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Antena;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface AntenaService {

    Page<Antena> findAll(Pageable page, Specification<Antena> spec);

    AntenaDTO save(AntenaDTO antenaDTO) throws BusinessException;

    Optional<AntenaDTO> findById(UUID id);

    Optional<AntenaDTO> update(AntenaDTO antenaDTO, UUID id);

    boolean delete(UUID id);
}

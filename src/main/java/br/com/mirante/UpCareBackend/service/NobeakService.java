package br.com.mirante.UpCareBackend.service;

import br.com.mirante.UpCareBackend.dto.NobeakDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Nobeak;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface NobeakService {
    Page<Nobeak> findAll(Pageable page, Specification<Nobeak>spec);

    NobeakDTO save (NobeakDTO nobeakDTO) throws BusinessException;

    Optional<NobeakDTO> findById(UUID id);

    Optional<NobeakDTO> update(UUID id, NobeakDTO nobeakDTO);

    boolean delete(UUID id);
}

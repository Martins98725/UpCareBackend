package br.com.mirante.UpCareBackend.service;

import br.com.mirante.UpCareBackend.dto.ExaustorDTO;
import br.com.mirante.UpCareBackend.dto.TrasnmissorDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Exaustor;
import br.com.mirante.UpCareBackend.models.Transmissor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ExautorService {

    Page<Exaustor> findAll(Pageable page, Specification<Exaustor> specification);

    ExaustorDTO save(ExaustorDTO exaustorDTO) throws BusinessException;

    Optional<ExaustorDTO> findById(UUID id);

    Optional<ExaustorDTO> update(UUID id, ExaustorDTO exaustorDTO);

    boolean delete(UUID id);
}

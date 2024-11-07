package br.com.mirante.UpCareBackend.service.Impl;

import br.com.mirante.UpCareBackend.dto.TrasnmissorDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Transmissor;
import br.com.mirante.UpCareBackend.service.TrasnmissorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransmissorServiceImpl implements TrasnmissorService {
    @Override
    public Page<Transmissor> findAll(Pageable page, Specification<Transmissor> specification) {
        return null;
    }

    @Override
    public TrasnmissorDTO save(TrasnmissorDTO trasnmissorDTO) throws BusinessException {
        return null;
    }

    @Override
    public Optional<TrasnmissorDTO> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<TrasnmissorDTO> update(UUID id, TrasnmissorDTO trasnmissorDTO) {
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}

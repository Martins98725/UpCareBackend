package br.com.mirante.UpCareBackend.service.Impl;

import br.com.mirante.UpCareBackend.dto.TrasnmissorDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.TransmissorMapper;
import br.com.mirante.UpCareBackend.models.Transmissor;
import br.com.mirante.UpCareBackend.repository.TransmissorRepository;
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
    @Autowired
    private TransmissorRepository transmissorRepository;

    @Override
    public Page<Transmissor> findAll(Pageable page, Specification<Transmissor> specification) {
        return transmissorRepository.findAll(specification, page);
    }

    @Override
    public TrasnmissorDTO save(TrasnmissorDTO trasnmissorDTO) throws BusinessException {
        Transmissor transmissor = TransmissorMapper.INSTANCE.transmissorDTOToTransmissor(trasnmissorDTO);

        transmissor = transmissorRepository.save(transmissor);
        return TransmissorMapper.INSTANCE.transmissorToTransmissorDTO(transmissor);
    }

    @Override
    public Optional<TrasnmissorDTO> findById(UUID id) {
        return transmissorRepository.findById(id).map(TransmissorMapper.INSTANCE::transmissorToTransmissorDTO);
    }

    @Override
    public Optional<TrasnmissorDTO> update(UUID id, TrasnmissorDTO trasnmissorDTO) {
        if (transmissorRepository.existsById(id)){
            Transmissor transmissor = TransmissorMapper.INSTANCE.transmissorDTOToTransmissor(trasnmissorDTO);
            transmissor.setId(id);
            transmissor = transmissorRepository.save(transmissor);
            return Optional.of(TransmissorMapper.INSTANCE.transmissorToTransmissorDTO(transmissor));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (transmissorRepository.existsById(id)) {
            transmissorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

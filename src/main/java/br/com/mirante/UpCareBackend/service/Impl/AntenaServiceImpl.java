package br.com.mirante.UpCareBackend.service.Impl;

import br.com.mirante.UpCareBackend.dto.AntenaDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.AntenaMapper;
import br.com.mirante.UpCareBackend.models.Antena;
import br.com.mirante.UpCareBackend.repository.AntenaRepository;
import br.com.mirante.UpCareBackend.service.AntenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AntenaServiceImpl implements AntenaService {
    @Autowired
    private AntenaRepository antenaRepository;


    @Override
    public Page<Antena> findAll(Pageable page, Specification<Antena> spec) {
        return antenaRepository.findAll(spec, page);
    }

    @Override
    public AntenaDTO create(AntenaDTO antenaDTO) throws BusinessException {
        Antena antena = AntenaMapper.INTANCE.antenaDTOToAntena(antenaDTO);

        //criar validação por codigo
        if (antenaRepository.existsById(antena.getId())){
            throw new BusinessException("Antena já existe");
        }

        antena = antenaRepository.save(antena);

        return AntenaMapper.INTANCE.antenaToAntenaDTO(antena);
    }

    @Override
    public Optional<AntenaDTO> findById(UUID id) {
        return antenaRepository.findById(id).map(AntenaMapper.INTANCE::antenaToAntenaDTO);
    }

    @Override
    public Optional<AntenaDTO> update(AntenaDTO antenaDTO, UUID id) {
        if (antenaRepository.existsById(id)){
            Antena antena = AntenaMapper.INTANCE.antenaDTOToAntena(antenaDTO);
            antena.setId(id);
            antena = antenaRepository.save(antena);

            return Optional.of(AntenaMapper.INTANCE.antenaToAntenaDTO(antena));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (antenaRepository.existsById(id)) {
            antenaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

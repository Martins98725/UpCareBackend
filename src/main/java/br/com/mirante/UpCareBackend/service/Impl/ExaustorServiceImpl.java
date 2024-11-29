package br.com.mirante.UpCareBackend.service.Impl;

import br.com.mirante.UpCareBackend.dto.ExaustorDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.ExaustorMapper;
import br.com.mirante.UpCareBackend.models.Exaustor;
import br.com.mirante.UpCareBackend.repository.ExaustorRepository;
import br.com.mirante.UpCareBackend.service.ExautorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExaustorServiceImpl implements ExautorService {
    @Autowired
    private ExaustorRepository exaustorRepository;


    @Override
    public Page<Exaustor> findAll(Pageable page, Specification<Exaustor> specification) {
        return exaustorRepository.findAll(specification, page);
    }

    @Override
    public ExaustorDTO save(ExaustorDTO exaustorDTO) throws BusinessException {
        Exaustor exaustor = ExaustorMapper.INSTANCE.exaustorDTOToExaustor(exaustorDTO);

        exaustor = exaustorRepository.save(exaustor);

        return ExaustorMapper.INSTANCE.exaustorToExaustorDTO(exaustor);
    }

    @Override
    public Optional<ExaustorDTO> findById(UUID id) {
        return exaustorRepository.findById(id).map(ExaustorMapper.INSTANCE::exaustorToExaustorDTO);
    }

    @Override
    public Optional<ExaustorDTO> update(UUID id, ExaustorDTO exaustorDTO) {
        if (exaustorRepository.existsById(id)) {
            Exaustor exaustor = ExaustorMapper.INSTANCE.exaustorDTOToExaustor(exaustorDTO);
            exaustor.setId(id);
            exaustor = exaustorRepository.save(exaustor);
            return Optional.of(ExaustorMapper.INSTANCE.exaustorToExaustorDTO(exaustor));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (exaustorRepository.existsById(id)){
            exaustorRepository.deleteById(id);

            return true;
        }
        return false;
    }
}

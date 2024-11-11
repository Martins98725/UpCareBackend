package br.com.mirante.UpCareBackend.service.Impl;

import br.com.mirante.UpCareBackend.dto.ParabolicaDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.ParabolicaMapper;
import br.com.mirante.UpCareBackend.models.Parabolica;
import br.com.mirante.UpCareBackend.repository.ParabolicaRepository;
import br.com.mirante.UpCareBackend.service.ParabolicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ParabolicaServiceImpl implements ParabolicaService {
    @Autowired
    private ParabolicaRepository parabolicaRepository;


    @Override
    public Page<Parabolica> findAll(Pageable page, Specification<Parabolica> specification) {
        return parabolicaRepository.findAll(specification, page);
    }

    @Override
    public ParabolicaDTO save(ParabolicaDTO parabolicaDTO) throws BusinessException {
        Parabolica parabolica = ParabolicaMapper.INSTANCE.parabolicaDTOToParabolica(parabolicaDTO);

        parabolica = parabolicaRepository.save(parabolica);
        return ParabolicaMapper.INSTANCE.parabolicaToParabolicaDTO(parabolica);
    }

    @Override
    public Optional<ParabolicaDTO> findById(UUID id) {
        return parabolicaRepository.findById(id).map(ParabolicaMapper.INSTANCE::parabolicaToParabolicaDTO);
    }

    @Override
    public Optional<ParabolicaDTO> update(UUID id, ParabolicaDTO parabolicaDTO) {
        if (parabolicaRepository.existsById(id)){
            Parabolica parabolica = ParabolicaMapper.INSTANCE.parabolicaDTOToParabolica(parabolicaDTO);
            parabolica.setId(id);

            parabolica = parabolicaRepository.save(parabolica);
            return Optional.of(ParabolicaMapper.INSTANCE.parabolicaToParabolicaDTO(parabolica));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (parabolicaRepository.existsById(id)) {
            parabolicaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

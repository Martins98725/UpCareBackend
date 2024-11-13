package br.com.mirante.UpCareBackend.service.Impl;

import br.com.mirante.UpCareBackend.dto.CombinadorDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.CombinadorMapper;
import br.com.mirante.UpCareBackend.models.Combinador;
import br.com.mirante.UpCareBackend.repository.CombinadorRepository;
import br.com.mirante.UpCareBackend.service.CombinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CombinadorServiceImpl implements CombinadorService {
    @Autowired
    private CombinadorRepository combinadorRepository;

    @Override
    public Page<Combinador> findAll(Pageable page, Specification<Combinador> spec) {
        return combinadorRepository.findAll(spec, page);
    }

    @Override
    public CombinadorDTO create(CombinadorDTO combinadorDTO) throws BusinessException {
        Combinador combinador = CombinadorMapper.INSTANCE.combinadorDTOToCombinador(combinadorDTO);

        combinador = combinadorRepository.save(combinador);
        return CombinadorMapper.INSTANCE.combinadorToCombinadorDTO(combinador);
    }

    @Override
    public Optional<CombinadorDTO> findById(UUID id) {
        return combinadorRepository.findById(id).map(CombinadorMapper.INSTANCE::combinadorToCombinadorDTO);
    }

    @Override
    public Optional<CombinadorDTO> update(CombinadorDTO combinadorDTO, UUID id) {
        if (combinadorRepository.existsById(id)){
            Combinador combinador = CombinadorMapper.INSTANCE.combinadorDTOToCombinador(combinadorDTO);
            combinador.setId(id);

            combinador = combinadorRepository.save(combinador);

            return Optional.of(CombinadorMapper.INSTANCE.combinadorToCombinadorDTO(combinador));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (combinadorRepository.existsById(id)) {
            combinadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

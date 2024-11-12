package br.com.mirante.UpCareBackend.service.Impl;

import br.com.mirante.UpCareBackend.dto.NobeakDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.NobeakMapper;
import br.com.mirante.UpCareBackend.models.Nobeak;
import br.com.mirante.UpCareBackend.models.Transmissor;
import br.com.mirante.UpCareBackend.repository.NobeakRepository;
import br.com.mirante.UpCareBackend.service.NobeakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NobeakServiceImpl implements NobeakService{
    @Autowired
    private NobeakRepository nobeakRepository;

    @Override
    public Page<Nobeak> findAll(Pageable page, Specification<Nobeak> spec){
        return nobeakRepository.findAll(spec,page);
    }

    @Override
    public NobeakDTO save(NobeakDTO nobeakDTO) throws BusinessException{
        Nobeak nobeak = NobeakMapper.INSTANCE.nobeakDTOToNobeak(nobeakDTO);
        nobeak = nobeakRepository.save(nobeak);
        return NobeakMapper.INSTANCE.nobeakToNobeakDTO(nobeak);
    }

    @Override
    public Optional<NobeakDTO> findById(UUID id){
        return nobeakRepository.findById(id).map(NobeakMapper.INSTANCE::nobeakToNobeakDTO);
    }

    @Override
    public Optional<NobeakDTO> update(UUID id ,NobeakDTO nobeakDTO){

        if (nobeakRepository.existsById(id)){
            Nobeak nobeak = NobeakMapper.INSTANCE.nobeakDTOToNobeak(nobeakDTO);
            nobeak.setId(id);

            nobeak = nobeakRepository.save(nobeak);
            return  Optional.of(NobeakMapper.INSTANCE.nobeakToNobeakDTO(nobeak));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (nobeakRepository.existsById(id)){
            nobeakRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

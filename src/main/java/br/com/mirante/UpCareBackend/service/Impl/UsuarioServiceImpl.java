package br.com.mirante.UpCareBackend.service.Impl;

import br.com.mirante.UpCareBackend.dto.UsuarioDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.UsuarioMapper;
import br.com.mirante.UpCareBackend.models.Usuario;
import br.com.mirante.UpCareBackend.repository.UsuarioRepository;
import br.com.mirante.UpCareBackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Page<Usuario> findAll(Pageable page, Specification<Usuario> specification) {
        return usuarioRepository.findAll(specification, page);
    }

    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO) throws BusinessException {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioDTOToUsuario(usuarioDTO);

        if (usuarioRepository.existsById(usuario.getId())) {
             throw new BusinessException("Usuario já existe");
        }

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
    }

    @Override
    public Optional<UsuarioDTO> findById(UUID id) {
        return usuarioRepository.findById(id).map(UsuarioMapper.INSTANCE::usuarioToUsuarioDTO);
    }

    @Override
    public Optional<UsuarioDTO> update(UUID id, UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = UsuarioMapper.INSTANCE.usuarioDTOToUsuario(usuarioDTO);
            usuario.setId(id);
            usuario = usuarioRepository.save(usuario);
            return Optional.of(UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

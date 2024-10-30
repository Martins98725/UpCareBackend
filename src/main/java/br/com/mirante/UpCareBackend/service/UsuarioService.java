package br.com.mirante.UpCareBackend.service;

import br.com.mirante.UpCareBackend.dto.UsuarioDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {
    Page<Usuario> findAll(Pageable page, Specification<Usuario> specification);

    UsuarioDTO create(UsuarioDTO usuario) throws BusinessException;

    Optional<UsuarioDTO> findById(UUID id);

    Optional<UsuarioDTO> update(UUID id, UsuarioDTO usuarioDTO);

    boolean delete(UUID id);
}

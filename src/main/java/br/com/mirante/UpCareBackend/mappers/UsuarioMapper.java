package br.com.mirante.UpCareBackend.mappers;

import br.com.mirante.UpCareBackend.dto.UsuarioDTO;
import br.com.mirante.UpCareBackend.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

}

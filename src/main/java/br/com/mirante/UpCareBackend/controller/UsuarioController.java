package br.com.mirante.UpCareBackend.controller;

import br.com.mirante.UpCareBackend.dto.UsuarioDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.UsuarioMapper;
import br.com.mirante.UpCareBackend.models.Usuario;
import br.com.mirante.UpCareBackend.service.UsuarioService;
import br.com.mirante.UpCareBackend.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna Dados dos Usuarios", name = "Usuario")
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar todos os usuarios", description = "Endpoint para consultar usuarios. ",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<UsuarioDTO>> findAll(Pageable pageable, SpecTemplate.UsuarioSpec spec) {
         Page<Usuario>consultaPage = usuarioService.findAll(pageable, spec);

        if (consultaPage.isEmpty()){
            return  new ResponseEntity<>(consultaPage.map(UsuarioMapper.INSTANCE::usuarioToUsuarioDTO), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(consultaPage.map(UsuarioMapper.INSTANCE::usuarioToUsuarioDTO), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de Usuarios.", description = "Endpoint para cadastrar Usuarios.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) throws BusinessException {

        UsuarioDTO usuarioSalvo = usuarioService.create(usuarioDTO);

        return ResponseEntity.ok(usuarioSalvo);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Usuarios por ID.", description = "Endpoint para buscar o usuario pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioDTO> getById(@PathVariable("id") UUID id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Usuarios por ID.", description = "Endpoint para atualizar o usuario pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioDTO> update(@PathVariable UUID id, @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.update(id, usuarioDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Usuarios por ID.", description = "Endpoint para remover, o usuario pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<UsuarioDTO> delete(@PathVariable UUID id){
        if (usuarioService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

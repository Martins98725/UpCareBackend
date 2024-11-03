package br.com.mirante.UpCareBackend.controller;


import br.com.mirante.UpCareBackend.dto.AntenaDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.AntenaMapper;
import br.com.mirante.UpCareBackend.models.Antena;
import br.com.mirante.UpCareBackend.service.AntenaService;
import br.com.mirante.UpCareBackend.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna Dados das Antenas", name = "Antena")
@RequestMapping(value = "/antenas")
public class AntenaController {
    @Autowired
    private AntenaService antenaService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar todos os Antenas", description = "Endpoint para consultar Antenas. ",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<AntenaDTO>> findAll(Pageable pageable, SpecTemplate.AntenaSpec spec) {
        Page<Antena>consultaPage = antenaService.findAll(pageable, spec);

        if (consultaPage.isEmpty()){
            return  new ResponseEntity<>(consultaPage.map(AntenaMapper.INSTANCE::antenaToAntenaDTO), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(consultaPage.map(AntenaMapper.INSTANCE::antenaToAntenaDTO), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de Antenas.", description = "Endpoint para cadastrar Antenas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AntenaDTO> create(@RequestBody AntenaDTO antenaDTO) throws BusinessException {

        AntenaDTO antenaSalva = antenaService.create(antenaDTO);

        return ResponseEntity.ok(antenaSalva);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Antenas por ID.", description = "Endpoint para buscar o Antena pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AntenaDTO> getById(@PathVariable UUID id) {
        return antenaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Usuarios por ID.", description = "Endpoint para atualizar o usuario pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AntenaDTO> update(@PathVariable UUID id, @RequestBody AntenaDTO antenaDTO){
        return antenaService.update(antenaDTO, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Usuarios por ID.", description = "Endpoint para remover, o usuario pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AntenaDTO> delete(@PathVariable UUID id){
        if (antenaService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

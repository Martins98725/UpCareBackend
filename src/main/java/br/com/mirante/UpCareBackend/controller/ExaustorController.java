package br.com.mirante.UpCareBackend.controller;

import br.com.mirante.UpCareBackend.dto.CombinadorDTO;
import br.com.mirante.UpCareBackend.dto.ExaustorDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.CombinadorMapper;
import br.com.mirante.UpCareBackend.mappers.ExaustorMapper;
import br.com.mirante.UpCareBackend.models.Combinador;
import br.com.mirante.UpCareBackend.models.Exaustor;
import br.com.mirante.UpCareBackend.service.ExautorService;
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
@Tag(description = "Retorna Dados dos Exaustores", name = "Exaustores")
@RequestMapping(value = "/exaustor")
public class ExaustorController {

    @Autowired
    private ExautorService exautorService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar todos os Exaustores", description = "Endpoint para consultar Exaustores. ",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<ExaustorDTO>> findAll(Pageable page, SpecTemplate.ExaustorSpec spec) {
        Page<Exaustor> consultaPage = exautorService.findAll(page, spec);
        if (consultaPage.isEmpty()) {
            return new ResponseEntity<>(consultaPage.map(ExaustorMapper.INSTANCE::exaustorToExaustorDTO), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(consultaPage.map(ExaustorMapper.INSTANCE::exaustorToExaustorDTO), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de Exaustores.", description = "Endpoint para cadastrar Exaustores.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ExaustorDTO> create(@RequestBody ExaustorDTO exaustorDTO) throws BusinessException {
        ExaustorDTO exaustorSalvo = exautorService.save(exaustorDTO);

        return ResponseEntity.ok(exaustorSalvo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Exaustores por ID.", description = "Endpoint para buscar a Exaustores pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ExaustorDTO> getById(@PathVariable UUID id) {
        return exautorService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Exaustores por ID.", description = "Endpoint para atualizar a Exaustores pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ExaustorDTO> update(@RequestBody ExaustorDTO exaustorDTO, @PathVariable UUID id){
        return exautorService.update(id, exaustorDTO).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Exaustores por ID.", description = "Endpoint para remover a Exaustores pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ExaustorDTO> delete(@PathVariable UUID id){
        if (exautorService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

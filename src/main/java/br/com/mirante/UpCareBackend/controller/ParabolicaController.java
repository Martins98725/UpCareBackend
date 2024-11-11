package br.com.mirante.UpCareBackend.controller;

import br.com.mirante.UpCareBackend.dto.ParabolicaDTO;
import br.com.mirante.UpCareBackend.dto.TrasnmissorDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.ParabolicaMapper;
import br.com.mirante.UpCareBackend.mappers.TransmissorMapper;
import br.com.mirante.UpCareBackend.models.Parabolica;
import br.com.mirante.UpCareBackend.service.ParabolicaService;
import br.com.mirante.UpCareBackend.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
@Tag(description = "Retorna Dados das Parabolicas", name = "Parabolicas")
@RequestMapping(value = "/parabolicas")
public class ParabolicaController {
    @Autowired
    private ParabolicaService parabolicaService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar todos as Parabolicas", description = "Endpoint para consultar Parabolicas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<ParabolicaDTO>> findAll(Pageable page, SpecTemplate.ParabolicaSpec spec){
        Page<Parabolica> consultaPage = parabolicaService.findAll(page, spec);

        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(ParabolicaMapper.INSTANCE::parabolicaToParabolicaDTO), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(consultaPage.map(ParabolicaMapper.INSTANCE::parabolicaToParabolicaDTO), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de Parabolica.", description = "Endpoint para cadastrar Parabolica.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ParabolicaDTO> create(@RequestBody ParabolicaDTO parabolicaDTO) throws BusinessException {
        ParabolicaDTO parabolicaSalva = parabolicaService.save(parabolicaDTO);

        return ResponseEntity.ok(parabolicaSalva);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Parabolicas por ID.", description = "Endpoint para buscar o Parabolicas pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ParabolicaDTO> getById(@PathVariable UUID id){

        return parabolicaService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Parabolicas por ID.", description = "Endpoint para atualizar o Parabolicas pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ParabolicaDTO> update(@PathVariable UUID id, @RequestBody ParabolicaDTO parabolicaDTO){
        return parabolicaService.update(id, parabolicaDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Transmissores por ID.", description = "Endpoint para remover, o Transmissor pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ParabolicaDTO> delete(@PathVariable UUID id){
        if (parabolicaService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

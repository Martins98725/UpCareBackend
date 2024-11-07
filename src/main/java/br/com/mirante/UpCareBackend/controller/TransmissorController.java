package br.com.mirante.UpCareBackend.controller;


import br.com.mirante.UpCareBackend.dto.TrasnmissorDTO;

import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.TransmissorMapper;
import br.com.mirante.UpCareBackend.models.Transmissor;
import br.com.mirante.UpCareBackend.service.TrasnmissorService;
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
@Tag(description = "Retorna Dados dos Transmissores", name = "Transmissor")
@RequestMapping(value = "/transmissores")
public class TransmissorController {
    @Autowired
    private TrasnmissorService trasnmissorService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar todos os Transmissores", description = "Endpoint para consultar Transmissores. ",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<TrasnmissorDTO>> findAll(Pageable pageable, SpecTemplate.TransmissorSpec spec){
        Page<Transmissor> consultaPage = trasnmissorService.findAll(pageable, spec);

        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(TransmissorMapper.INSTANCE::transmissorToTransmissorDTO), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(consultaPage.map(TransmissorMapper.INSTANCE::transmissorToTransmissorDTO), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de Transmissores.", description = "Endpoint para cadastrar Transmissores.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<TrasnmissorDTO> create(@RequestBody TrasnmissorDTO trasnmissorDTO) throws BusinessException {
        TrasnmissorDTO transmissorSalvo = trasnmissorService.save(trasnmissorDTO);

        return ResponseEntity.ok(transmissorSalvo);

    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Transmissores por ID.", description = "Endpoint para buscar o Transmissor pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<TrasnmissorDTO> getById(@PathVariable UUID id) {
        return trasnmissorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Transmissores por ID.", description = "Endpoint para atualizar o Transmissores pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<TrasnmissorDTO> update(@PathVariable UUID id, @RequestBody TrasnmissorDTO trasnmissorDTO){
        return trasnmissorService.update(id, trasnmissorDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Transmissores por ID.", description = "Endpoint para remover, o Transmissor pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<TrasnmissorDTO> delete(@PathVariable UUID id){
        if (trasnmissorService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

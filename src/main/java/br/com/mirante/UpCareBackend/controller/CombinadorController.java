package br.com.mirante.UpCareBackend.controller;

import br.com.mirante.UpCareBackend.dto.CombinadorDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.CombinadorMapper;
import br.com.mirante.UpCareBackend.models.Combinador;
import br.com.mirante.UpCareBackend.service.CombinadorService;
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
@Tag(description = "Retorna Dados dos Combinadores", name = "Combinadores")
@RequestMapping(value = "/combinador")
public class CombinadorController {
    @Autowired
    private CombinadorService combinadorService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar todos os Combinadores", description = "Endpoint para consultar Combinadores. ",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<CombinadorDTO>> findAll(Pageable page, SpecTemplate.CombinadorSpec spec) {
        Page<Combinador> consultaPage = combinadorService.findAll(page, spec);
        if (consultaPage.isEmpty()) {
            return new ResponseEntity<>(consultaPage.map(CombinadorMapper.INSTANCE::combinadorToCombinadorDTO), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(consultaPage.map(CombinadorMapper.INSTANCE::combinadorToCombinadorDTO), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de combinadores.", description = "Endpoint para cadastrar combinadores.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<CombinadorDTO> create(@RequestBody CombinadorDTO combinadorDTO) throws BusinessException {
        CombinadorDTO combinadorSalvo = combinadorService.save(combinadorDTO);

        return ResponseEntity.ok(combinadorSalvo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar combinadores por ID.", description = "Endpoint para buscar a combinadores pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<CombinadorDTO> getById(@PathVariable UUID id) {
        return combinadorService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar combinadores por ID.", description = "Endpoint para atualizar a combinadores pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<CombinadorDTO> update(@RequestBody CombinadorDTO combinadorDTO, @PathVariable UUID id){
        return combinadorService.update(combinadorDTO, id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover combinadores por ID.", description = "Endpoint para remover a combinadores pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<CombinadorDTO> delete(@PathVariable UUID id){
        if (combinadorService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

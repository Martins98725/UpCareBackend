package br.com.mirante.UpCareBackend.controller;

import br.com.mirante.UpCareBackend.dto.EstacaoDTO;
import br.com.mirante.UpCareBackend.dto.UsuarioDTO;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.mappers.EstacaoMapper;
import br.com.mirante.UpCareBackend.models.Estacao;
import br.com.mirante.UpCareBackend.service.EstacaoService;
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
@Tag(description = "Retorna Dados das Estações", name = "estação")
@RequestMapping(value = "/estacao")
public class EstacaoController {

    @Autowired
    private EstacaoService estacaoService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar todas as estações", description = "Endpoint para consultar estações. ",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<EstacaoDTO>> findAl(Pageable page, SpecTemplate.EstacaoSpec spec){
        Page<Estacao> consultaPage = estacaoService.findAll(page, spec);
        if (consultaPage.isEmpty()){
            return  new ResponseEntity<>(consultaPage.map(EstacaoMapper.INSTANCE::estacaoToEstacaoDTO), HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(consultaPage.map(EstacaoMapper.INSTANCE::estacaoToEstacaoDTO), HttpStatus.OK);

    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de estações.", description = "Endpoint para cadastrar estações.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EstacaoDTO> create(@RequestBody EstacaoDTO estacaoDTO) throws BusinessException {
        EstacaoDTO estacaoSalva = estacaoService.create(estacaoDTO);

        return ResponseEntity.ok(estacaoSalva);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar estações por ID.", description = "Endpoint para buscar a estação pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EstacaoDTO> getById(@PathVariable UUID id){
        return estacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Atualizar estações por ID.", description = "Endpoint para atualizar a estação pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EstacaoDTO> update(@RequestBody EstacaoDTO estacaoDTO, @PathVariable UUID id){
        return estacaoService.update(estacaoDTO, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover estações por ID.", description = "Endpoint para remover a estação pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EstacaoDTO> delete(@PathVariable UUID id){
        if (estacaoService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
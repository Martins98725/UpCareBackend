package br.com.mirante.UpCareBackend.controller;

import br.com.mirante.UpCareBackend.dto.NobeakDTO;
import br.com.mirante.UpCareBackend.mappers.NobeakMapper;
import br.com.mirante.UpCareBackend.mappers.ParabolicaMapper;
import br.com.mirante.UpCareBackend.models.Nobeak;
import br.com.mirante.UpCareBackend.service.NobeakService;
import br.com.mirante.UpCareBackend.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna Dados dos Nobreak", name = "nobreak")
@RequestMapping(value = "/nobreak")
public class NobreakController {
    @Autowired
    private NobeakService nobeakService;

    @GetMapping
    public ResponseEntity<Page<NobeakDTO>> findAll(Pageable page, SpecTemplate.NobeakSpec spec){
        Page<Nobeak> consultaPage = nobeakService.findAll(page , spec);
        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(NobeakMapper.INSTANCE::nobeakToNobeakDTO), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(consultaPage.map(NobeakMapper.INSTANCE::nobeakToNobeakDTO), HttpStatus.OK);
    }

}

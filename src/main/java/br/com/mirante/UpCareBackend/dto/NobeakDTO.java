package br.com.mirante.UpCareBackend.dto;

import br.com.mirante.UpCareBackend.models.enums.Categoria;
import br.com.mirante.UpCareBackend.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NobeakDTO {

    private UUID id ;

    private String codigo ;

    private String marca;

    private String modelo;

    private Categoria categoria;

    private Status status;

}

package br.com.mirante.UpCareBackend.dto;

import br.com.mirante.UpCareBackend.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExaustorDTO {
    private UUID id;
    private String codigo;
    private String marca;
    private String modelo;
    private Status status;
}

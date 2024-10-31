package br.com.mirante.UpCareBackend.dto;

import br.com.mirante.UpCareBackend.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstacaoDTO {
    private UUID id;
    private String nome;
    private double longitude;
    private double latitude;
    private String endereco;
    private String linkGrafana;
    private Status status;

}

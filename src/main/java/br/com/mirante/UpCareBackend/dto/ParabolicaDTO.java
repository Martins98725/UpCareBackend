package br.com.mirante.UpCareBackend.dto;

import br.com.mirante.UpCareBackend.models.Estacao;
import br.com.mirante.UpCareBackend.models.enums.Categoria;
import br.com.mirante.UpCareBackend.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParabolicaDTO {
    private UUID id;
    private String codigo;
    private String marca;
    private String modelo;
    private Categoria categoria;
    private Status status;
    private float diametro;
    private String satelite;
    //private Estacao estacao;

}

package br.com.mirante.UpCareBackend.dto;

import br.com.mirante.UpCareBackend.models.enums.Categoria;
import br.com.mirante.UpCareBackend.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrasnmissorDTO {
    private UUID id;
    private String codigo;
    private String marca;
    private String modelo;
    private Categoria categoria;
    private Status status;
    private float programado;
    private float canalVIrtual;
    private float canalFisico;
    private String acopladorUm;
    private String acopladorDois;
}

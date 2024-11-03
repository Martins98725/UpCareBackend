package br.com.mirante.UpCareBackend.dto;

import br.com.mirante.UpCareBackend.models.Estacao;
import br.com.mirante.UpCareBackend.models.enums.Categoria;
import br.com.mirante.UpCareBackend.models.enums.PosicaoDaTorre;
import br.com.mirante.UpCareBackend.models.enums.Status;
import br.com.mirante.UpCareBackend.models.enums.TipoAntena;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AntenaDTO {
    private UUID id;
    private String codigo;
    private String marca;
    private String modelo;
    private Status status;
    private double vr;
    private TipoAntena tipoAntena;
    private String gain;
    private PosicaoDaTorre posicaoDaTorre;
    private Categoria categoria;
    private EstacaoDTO estacao;
}

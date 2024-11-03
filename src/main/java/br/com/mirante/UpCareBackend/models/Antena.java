package br.com.mirante.UpCareBackend.models;

import br.com.mirante.UpCareBackend.models.enums.Categoria;
import br.com.mirante.UpCareBackend.models.enums.PosicaoDaTorre;
import br.com.mirante.UpCareBackend.models.enums.Status;
import br.com.mirante.UpCareBackend.models.enums.TipoAntena;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Antena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne
    private Estacao estacao;


    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}

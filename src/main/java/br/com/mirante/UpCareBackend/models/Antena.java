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

    @Column(nullable = false, name = "CODIGO", length = 50)
    private String codigo;

    @Column(nullable = false, length = 50,  name = "MARCA")
    private String marca;

    @Column(nullable = false, length = 50, name = "MODELO")
    private String modelo;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false, length = 50, name = "VR")
    private double vr;

    @Column(name = "TIPO_ANTENA")
    @Enumerated(EnumType.STRING)
    private TipoAntena tipoAntena;

    @Column(nullable = false, length = 50, name = "GAIN")
    private String gain;

    @Column(name = "POSICAO_DA_TORRE")
    @Enumerated(EnumType.STRING)
    private PosicaoDaTorre posicaoDaTorre;

    @Column(name = "CATEGORIA")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "estacao_id")
    private Estacao estacao;

    @ManyToOne
    @JoinColumn(name = "TRANSMISSOR_ID")
    private Transmissor transmissor;


    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}

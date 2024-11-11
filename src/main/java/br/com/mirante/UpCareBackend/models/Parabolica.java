package br.com.mirante.UpCareBackend.models;

import br.com.mirante.UpCareBackend.models.enums.Categoria;
import br.com.mirante.UpCareBackend.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PARABOLICA")
public class Parabolica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "CODIGO", length = 50)
    private String codigo;

    @Column(nullable = false, length = 50,  name = "MARCA")
    private String marca;

    @Column(nullable = false, length = 50, name = "MODELO")
    private String modelo;

    @Column(name = "CATEGORIA")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false, length = 50, name = "DIAMETRO")
    private float diametro;

    @Column(nullable = false, length = 50, name = "SATELITE")
    private String satelite;

    @ManyToOne
    @JoinColumn(name = "ESTACAO_ID")
    private Estacao estacao;

    @PrePersist
    public void generatedUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}

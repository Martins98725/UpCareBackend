package br.com.mirante.UpCareBackend.models;

import br.com.mirante.UpCareBackend.models.enums.Categoria;
import br.com.mirante.UpCareBackend.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trasnmissor")
public class Transmissor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "CODIGO", nullable = false, length = 50)
    private String codigo;

    @Column(name = "MARCA", nullable = false, length = 30)
    private String marca;

    @Column(name = "MODELO", nullable = false, length = 30)
    private String modelo;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA")
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    //revisar esse tipo de dado
    @Column(name = "PROGRAMADO", nullable = false, length = 50)
    private float programado;

    @Column(name = "CANAL_VIRTUAL", nullable = false, length = 50)
    private float canalVIrtual;

    @Column(name = "CANAL_FISICO", nullable = false, length = 50)
    private float canalFisico;

    @Column(name = "ACLOPADOR_ UM", nullable = false, length = 70)
    private String acopladorUm;

    @Column(name = "ACOPlADOR_DOIS", nullable = false, length = 70)
    private String acopladorDois;

    @ManyToOne
    @JoinColumn(name = "ESTACAO_ID")
    private Estacao estacao;

    @OneToMany(mappedBy = "transmissor", cascade = CascadeType.ALL)
    private List<Antena> antenas;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}

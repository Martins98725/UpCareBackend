package br.com.mirante.UpCareBackend.models;

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
@Table
public class Estacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "LONGITUDE", nullable = false, length = 100)
    private double longitude;

    @Column(name = "LATITUDE", nullable = false, length = 100)
    private double latitude;

    @Column(name = "ENDERECO", nullable = false, length = 50)
    private String endereco;

    @Column(name = "LINK_GRAFANA", nullable = false, length = 75)
    private String linkGrafana;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "estacao",  cascade = CascadeType.ALL)
    private List<Antena> antenas;

    @OneToMany(mappedBy = "estacao", cascade = CascadeType.ALL)
    private List<Transmissor> transmissors;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}

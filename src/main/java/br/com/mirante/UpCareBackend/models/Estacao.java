package br.com.mirante.UpCareBackend.models;

import br.com.mirante.UpCareBackend.models.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estacao {
    @Id
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
    private Status status;
}

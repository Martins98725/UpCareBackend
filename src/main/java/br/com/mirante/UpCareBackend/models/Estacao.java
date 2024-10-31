package br.com.mirante.UpCareBackend.models;

import br.com.mirante.UpCareBackend.models.enums.Status;
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

    private String nome;

    private double longitude;

    private double latitude;

    private String endereco;

    private String linkGrafana;

    private Status status;
}

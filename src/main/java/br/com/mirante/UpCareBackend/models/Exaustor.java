package br.com.mirante.UpCareBackend.models;

import br.com.mirante.UpCareBackend.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXAUSTOR")
public class Exaustor {
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

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}

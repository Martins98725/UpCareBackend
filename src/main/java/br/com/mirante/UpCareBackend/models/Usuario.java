package br.com.mirante.UpCareBackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "SENHA", nullable = false, length = 15)
    private String senha;

    @Column(name = "CONTATO", nullable = false, length = 15)
    private String contato;

    @Column(name = "EMPRESA", nullable = false, length = 50)
    private String empresa;

    @Column(name = "CONTATO_EMPRESA", nullable = false, length = 15)
    private String contatoEmpresa;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Role> roles = new ArrayList<>();

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}

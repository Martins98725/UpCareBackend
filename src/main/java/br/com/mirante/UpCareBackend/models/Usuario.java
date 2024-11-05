package br.com.mirante.UpCareBackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    private static final Logger logger = LoggerFactory.getLogger(Usuario.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "EMAIL", nullable = false, length = 50)
    @Email
    private String email;

    @Column(name = "SENHA", nullable = false, length = 15)
    private String senha;

    @Column(name = "CONTATO", nullable = false, length = 15)
    private String contato;

    @Column(name = "EMPRESA", nullable = false, length = 50)
    private String empresa;

    @Column(name = "CONTATO_EMPRESA", nullable = false, length = 15)
    private String contatoEmpresa;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
            logger.info("UUID generated" + id);
        }
    }
}

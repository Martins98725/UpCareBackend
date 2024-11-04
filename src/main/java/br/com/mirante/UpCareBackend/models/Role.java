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
//obs: seria uma boa fazer um enum de role ao inves de uma entidade completa
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    List<Usuario> usuarios = new ArrayList<>();
}

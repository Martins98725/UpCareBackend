package br.com.mirante.UpCareBackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

//obs: seria uma boa fazer um enum de perimissão ao inves de uma entidade completa
public class Role {
    @Id
    private UUID id;
    private String name;

    @ManyToMany
    List<Usuario> usuarios = new ArrayList<>();
}

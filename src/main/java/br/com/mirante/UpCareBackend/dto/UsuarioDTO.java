package br.com.mirante.UpCareBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private String contato;
    private String empresa;
    private String contatoEmpresa;
}

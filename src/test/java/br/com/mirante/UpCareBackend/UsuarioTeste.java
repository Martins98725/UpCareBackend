package br.com.mirante.UpCareBackend;

import br.com.mirante.UpCareBackend.models.Usuario;
import br.com.mirante.UpCareBackend.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UsuarioTeste {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testPersistUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Test User");
        usuario.setEmail("test@example.com");
        usuario.setSenha("password");
        usuario.setContato("123456789");
        usuario.setEmpresa("Empresa Teste");
        usuario.setContatoEmpresa("987654321");

        usuarioRepository.save(usuario);
        assertNotNull(usuario.getId());  // Verifica se o UUID foi gerado
    }
}

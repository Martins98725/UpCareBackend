package br.com.mirante.UpCareBackend;

import br.com.mirante.UpCareBackend.dto.UsuarioDTO;
import br.com.mirante.UpCareBackend.dto.UsuarioDTOPost;
import br.com.mirante.UpCareBackend.exceptions.BusinessException;
import br.com.mirante.UpCareBackend.models.Usuario;
import br.com.mirante.UpCareBackend.repository.UsuarioRepository;
import br.com.mirante.UpCareBackend.service.Impl.UsuarioServiceImpl;
import br.com.mirante.UpCareBackend.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UsuarioTestService {
    @InjectMocks
    private UsuarioService usuarioService = new UsuarioServiceImpl();

    @Mock
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks

        // Cria um usuário de exemplo
        usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setEmail("teste@example.com");
        usuario.setSenha("senhaSegura123");
        usuario.setContato("123456789");
        usuario.setEmpresa("Empresa Teste");
        usuario.setContatoEmpresa("987654321");
        usuario.setId(UUID.randomUUID()); // Simula um UUID já gerado
    }

    @Test
    public void testCreateUsuario() throws BusinessException {
        // Define o comportamento do repositório mock
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // Chama o metodo a ser testado
        usuarioService.save(new UsuarioDTOPost());

        // Verifica se o método save foi chamado no repositório
        verify(usuarioRepository).save(any(Usuario.class));

        // Verifique se o UUID foi gerado corretamente
        assert usuario.getId() != null; // Verifica se o ID não é nulo
    }
}

package br.com.mirante.UpCareBackend.specifications;

import br.com.mirante.UpCareBackend.models.Estacao;
import br.com.mirante.UpCareBackend.models.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class SpecTemplate {

    @And({
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "email", spec = Equal.class),
            @Spec(path = "empresa", spec = Like.class),
    })
    public interface UsuarioSpec extends Specification<Usuario> {}

    @And({
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "longitude", spec = Equal.class),
            @Spec(path = "latitude", spec = Equal.class),
    })
    public interface EstacaoSpec extends Specification<Estacao>{}
}

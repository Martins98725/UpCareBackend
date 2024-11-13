package br.com.mirante.UpCareBackend.repository;

import br.com.mirante.UpCareBackend.models.Combinador;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CombinadorRepository extends JpaRepository<Combinador, UUID>, JpaSpecificationExecutor<Combinador> {
}

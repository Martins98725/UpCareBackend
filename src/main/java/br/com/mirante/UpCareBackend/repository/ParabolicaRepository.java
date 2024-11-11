package br.com.mirante.UpCareBackend.repository;

import br.com.mirante.UpCareBackend.models.Parabolica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParabolicaRepository extends JpaRepository<Parabolica, UUID>, JpaSpecificationExecutor<Parabolica> {
}

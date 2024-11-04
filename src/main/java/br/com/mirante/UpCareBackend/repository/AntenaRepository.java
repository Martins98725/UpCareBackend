package br.com.mirante.UpCareBackend.repository;

import br.com.mirante.UpCareBackend.models.Antena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AntenaRepository extends JpaRepository<Antena, UUID>, JpaSpecificationExecutor<Antena> {
    boolean existsAntenaByCodigo(String codigo);
}

package br.com.mirante.UpCareBackend.repository;

import br.com.mirante.UpCareBackend.models.Transmissor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransmissorRepository extends JpaRepository<Transmissor, UUID>, JpaSpecificationExecutor<Transmissor> {
}

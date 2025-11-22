package github.henriquewegner.teste_backend.infrastructure.repositories;

import github.henriquewegner.teste_backend.infrastructure.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepositoryJpa extends JpaRepository<ClienteEntity, Integer> {

    Optional<ClienteEntity> findById(Integer id);

}

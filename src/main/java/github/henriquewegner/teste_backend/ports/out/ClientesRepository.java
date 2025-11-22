package github.henriquewegner.teste_backend.ports.out;

import github.henriquewegner.teste_backend.infrastructure.entities.ClienteEntity;

import java.util.Optional;

public interface ClientesRepository {

    Optional<ClienteEntity> findById(Integer id);
    ClienteEntity save(ClienteEntity entity);
}

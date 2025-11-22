package github.henriquewegner.teste_backend.infrastructure.adapters;

import github.henriquewegner.teste_backend.infrastructure.entities.ClienteEntity;
import github.henriquewegner.teste_backend.infrastructure.repositories.ClientesRepositoryJpa;
import github.henriquewegner.teste_backend.ports.out.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientesRepositoryImpl implements ClientesRepository {

    private final ClientesRepositoryJpa clientesRepositoryJpa;

    @Override
    public Optional<ClienteEntity> findById(Integer id) {
        return clientesRepositoryJpa.findById(id);
    }

    @Override
    public ClienteEntity save(ClienteEntity entity) {
        return clientesRepositoryJpa.save(entity);
    }
}

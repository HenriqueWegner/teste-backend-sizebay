package github.henriquewegner.teste_backend.infrastructure.adapters;

import github.henriquewegner.teste_backend.infrastructure.entities.TransacaoEntity;
import github.henriquewegner.teste_backend.infrastructure.repositories.TransacoesRepositoryJpa;
import github.henriquewegner.teste_backend.ports.out.TransacoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransacoesRepositoryImpl implements TransacoesRepository {

    private final TransacoesRepositoryJpa transacoesRepositoryJpa;

    @Override
    public TransacaoEntity save(TransacaoEntity entity) {
        return transacoesRepositoryJpa.save(entity);
    }

    @Override
    public List<TransacaoEntity> findByClienteId(Integer id) {
        return transacoesRepositoryJpa.findByClienteId(id);
    }
}

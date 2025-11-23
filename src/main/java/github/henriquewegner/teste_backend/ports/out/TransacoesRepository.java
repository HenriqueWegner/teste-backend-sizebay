package github.henriquewegner.teste_backend.ports.out;

import github.henriquewegner.teste_backend.infrastructure.entities.TransacaoEntity;

import java.util.List;

public interface TransacoesRepository {

    TransacaoEntity save(TransacaoEntity entity);
    List<TransacaoEntity> findByClienteIdOrderByRealizadaEmDesc(Integer id);
}

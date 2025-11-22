package github.henriquewegner.teste_backend.infrastructure.repositories;

import github.henriquewegner.teste_backend.infrastructure.entities.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacoesRepositoryJpa extends JpaRepository<TransacaoEntity, Integer> {

    List<TransacaoEntity> findByClienteId(Integer id);
}

package github.henriquewegner.teste_backend.infrastructure.repositories;

import github.henriquewegner.teste_backend.infrastructure.entities.ClienteEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientesRepositoryJpa extends JpaRepository<ClienteEntity, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select c from ClienteEntity c where c.id = :id")
    Optional<ClienteEntity> findByIdForUpdate(@Param("id") Integer id);

}

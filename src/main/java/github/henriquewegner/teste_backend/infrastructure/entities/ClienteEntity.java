package github.henriquewegner.teste_backend.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClienteEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "limite")
    private Integer limite;

    @Column(name = "saldo")
    private Integer saldo;
}

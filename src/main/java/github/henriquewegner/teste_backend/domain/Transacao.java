package github.henriquewegner.teste_backend.domain;

import lombok.Data;

import java.time.Instant;

@Data
public class Transacao {

    private Integer id;
    private Integer clienteId;
    private String tipo;
    private Integer valor;
    private String descricao;
    private Instant realizadaEm;
}

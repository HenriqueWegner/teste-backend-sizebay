package github.henriquewegner.teste_backend.web.dto.response;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ExtratoResponseDTO(
    SaldoResponseDTO saldo,
    List<UltimasTransacoesResponseDTO> ultimasTransacoes
) {
}

package github.henriquewegner.teste_backend.web.dto.response;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.Instant;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record UltimasTransacoesResponseDTO(
        Integer valor,
        char tipo,
        String descricao,
        Instant realizadaEm
) {
}

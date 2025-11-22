package github.henriquewegner.teste_backend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SaldoResponseDTO(
        Integer id,
        Instant dataExtrato,
        Integer limite
) {
    public SaldoResponseDTO {
        if (dataExtrato == null) {
            dataExtrato = Instant.now();
        }
    }
}

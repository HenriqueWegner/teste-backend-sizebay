package github.henriquewegner.teste_backend.web.dto.request;

import jakarta.validation.constraints.*;

public record TransacaoRequestDTO(

        @NotNull(message = "O valor deve ser preenchido")
        @Positive(message = "O valor deve ser positivo")
        Integer valor,

        @NotBlank(message = "O tipo deve ser preenchido")
        @Pattern(regexp = "^[cd]$", message = "O campo deve ser 'c' ou 'd'")
        String tipo,

        @Size(min = 1, max = 10, message = "O valor deve ser entre 1 e 10")
        String descricao
) {
}

package github.henriquewegner.teste_backend.ports.in;

import github.henriquewegner.teste_backend.web.dto.request.TransacaoRequestDTO;
import github.henriquewegner.teste_backend.web.dto.response.ExtratoResponseDTO;
import github.henriquewegner.teste_backend.web.dto.response.TransacaoResponseDTO;

import java.util.Optional;

public interface ClientesUseCase{

    Optional<TransacaoResponseDTO> saveTransacao(Integer id, TransacaoRequestDTO dto);
    Optional<ExtratoResponseDTO> buildExtrato(Integer id);
}

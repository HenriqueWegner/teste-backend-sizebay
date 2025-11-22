package github.henriquewegner.teste_backend.web.controller;

import github.henriquewegner.teste_backend.application.usecase.ClientesUseCaseImpl;
import github.henriquewegner.teste_backend.web.dto.request.TransacaoRequestDTO;
import github.henriquewegner.teste_backend.web.dto.response.ExtratoResponseDTO;
import github.henriquewegner.teste_backend.web.dto.response.TransacaoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
@Slf4j
public class ClientesController {

    private final ClientesUseCaseImpl clientesUseCase;

    @PostMapping("{id}/transacoes")
    public ResponseEntity<TransacaoResponseDTO> saveTransacao(@PathVariable("id") Integer id,
                                                              @RequestBody @Valid TransacaoRequestDTO dto){
        log.info("Iniciando transação.");
        Optional<TransacaoResponseDTO> transacaoResponseDto = clientesUseCase.saveTransacao(id, dto);

        return ResponseEntity.of(transacaoResponseDto);
    }

    @GetMapping("{id}/extrato")
    public ResponseEntity<ExtratoResponseDTO> getExtrato(@PathVariable("id") Integer id){
        log.info("Procurando extrato para id: {}", id);

        Optional<ExtratoResponseDTO> dto = clientesUseCase.buildExtrato(id);

        return ResponseEntity.of(dto);
    }
}

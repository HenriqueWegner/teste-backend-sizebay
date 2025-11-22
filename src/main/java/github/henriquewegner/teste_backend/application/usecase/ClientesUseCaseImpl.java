package github.henriquewegner.teste_backend.application.usecase;

import github.henriquewegner.teste_backend.domain.Cliente;
import github.henriquewegner.teste_backend.domain.Transacao;
import github.henriquewegner.teste_backend.infrastructure.entities.ClienteEntity;
import github.henriquewegner.teste_backend.infrastructure.entities.TransacaoEntity;
import github.henriquewegner.teste_backend.ports.in.ClientesUseCase;
import github.henriquewegner.teste_backend.ports.out.ClientesRepository;
import github.henriquewegner.teste_backend.ports.out.TransacoesRepository;
import github.henriquewegner.teste_backend.web.common.exception.SaldoInconsistenteException;
import github.henriquewegner.teste_backend.web.dto.request.TransacaoRequestDTO;
import github.henriquewegner.teste_backend.web.dto.response.ExtratoResponseDTO;
import github.henriquewegner.teste_backend.web.dto.response.SaldoResponseDTO;
import github.henriquewegner.teste_backend.web.dto.response.TransacaoResponseDTO;
import github.henriquewegner.teste_backend.web.dto.response.UltimasTransacoesResponseDTO;
import github.henriquewegner.teste_backend.web.mapper.ClienteMapper;
import github.henriquewegner.teste_backend.web.mapper.TransacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientesUseCaseImpl implements ClientesUseCase {

    private final ClientesRepository clientesRepository;
    private final TransacoesRepository transacoesRepository;
    private final ClienteMapper clienteMapper;
    private final TransacaoMapper transacaoMapper;

    @Override
    @Transactional
    public Optional<TransacaoResponseDTO> saveTransacao(Integer id, TransacaoRequestDTO dto) {

        Optional<ClienteEntity> clienteEntity = clientesRepository.findById(id);

        if(clienteEntity.isEmpty()){
            return Optional.empty();
        }

        Cliente cliente = clienteMapper.toDomain(clienteEntity.get());
        Integer valor = dto.valor() * -1;
        Integer saldo = cliente.getSaldo();
        Integer limite = cliente.getLimite();

        if("d".equals(dto.tipo()) && (valor + saldo) < limite * -1){
            throw new SaldoInconsistenteException("Operação não permitida, valor inconsistente.");
        }

        cliente.setSaldo(saldo + valor);

        ClienteEntity preparedClientEntity = clienteMapper.toEntity(cliente);
        clientesRepository.save(preparedClientEntity);

        TransacaoEntity transacaoEntity = transacaoMapper.toEntity(dto);
        transacaoEntity.setClienteId(id);
        transacoesRepository.save(transacaoEntity);

        return Optional.of(clienteMapper.toDto(preparedClientEntity));
    }

    @Override
    public Optional<ExtratoResponseDTO> buildExtrato(Integer id) {
        return clientesRepository.findById(id)
                .map(clienteEntity -> {
                    SaldoResponseDTO saldo = clienteMapper.toDto(clienteMapper.toDomain(clienteEntity));

                    List<TransacaoEntity> ultimasTransacoesEntity = transacoesRepository.findByClienteId(clienteEntity.getId());
                    List<UltimasTransacoesResponseDTO> ultimasTransacoes = ultimasTransacoesEntity == null
                            ? Collections.emptyList()
                            : transacaoMapper.toDto(transacaoMapper.toDomain(ultimasTransacoesEntity));

                    return new ExtratoResponseDTO(saldo, ultimasTransacoes);
                });
    }
}

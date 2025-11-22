package github.henriquewegner.teste_backend.web.mapper;

import github.henriquewegner.teste_backend.domain.Cliente;
import github.henriquewegner.teste_backend.infrastructure.entities.ClienteEntity;
import github.henriquewegner.teste_backend.web.dto.response.SaldoResponseDTO;
import github.henriquewegner.teste_backend.web.dto.response.TransacaoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente toDomain(ClienteEntity entity);
    ClienteEntity toEntity(Cliente cliente);
    SaldoResponseDTO toDto(Cliente cliente);
    TransacaoResponseDTO toDto(ClienteEntity entity);
}

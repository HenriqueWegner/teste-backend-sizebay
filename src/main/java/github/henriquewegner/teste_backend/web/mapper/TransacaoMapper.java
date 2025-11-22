package github.henriquewegner.teste_backend.web.mapper;

import github.henriquewegner.teste_backend.domain.Transacao;
import github.henriquewegner.teste_backend.infrastructure.entities.TransacaoEntity;
import github.henriquewegner.teste_backend.web.dto.request.TransacaoRequestDTO;
import github.henriquewegner.teste_backend.web.dto.response.UltimasTransacoesResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {

    List<Transacao> toDomain(List<TransacaoEntity> entity);
    List<UltimasTransacoesResponseDTO> toDto(List<Transacao> dto);
    Transacao toDomain(TransacaoRequestDTO dto);
    TransacaoEntity toEntity(TransacaoRequestDTO dto);

}

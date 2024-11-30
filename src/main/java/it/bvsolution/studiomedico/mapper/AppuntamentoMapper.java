package it.bvsolution.studiomedico.mapper;

import it.bvsolution.studiomedico.dto.appuntamenti.AppuntamentoRequestDTO;
import it.bvsolution.studiomedico.dto.appuntamenti.AppuntamentoResponseDTO;
import it.bvsolution.studiomedico.model.AppuntamentiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppuntamentoMapper {

    AppuntamentoMapper INSTANCE = Mappers.getMapper(AppuntamentoMapper.class);

    AppuntamentiEntity toEntity(AppuntamentoRequestDTO requestDTO);

    AppuntamentoResponseDTO toResponseDTO(AppuntamentiEntity entity);

    List<AppuntamentoResponseDTO> toResponseDTOList(List<AppuntamentiEntity> entities);

}

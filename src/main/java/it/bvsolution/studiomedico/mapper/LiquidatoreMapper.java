package it.bvsolution.studiomedico.mapper;

import it.bvsolution.studiomedico.dto.liquidatori.LiquidatoreRequestDTO;
import it.bvsolution.studiomedico.dto.liquidatori.LiquidatoreResponseDTO;
import it.bvsolution.studiomedico.model.LiquidatoriEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LiquidatoreMapper {

    LiquidatoriEntity toEntity(LiquidatoreRequestDTO dto);

    LiquidatoreResponseDTO toResponseDTO(LiquidatoriEntity entity);

    List<LiquidatoreResponseDTO> toResponseDTOList(List<LiquidatoriEntity> entities);
}

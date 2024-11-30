package it.bvsolution.studiomedico.mapper;

import it.bvsolution.studiomedico.dto.sedi.SedeRequestDTO;
import it.bvsolution.studiomedico.dto.sedi.SedeResponseDTO;
import it.bvsolution.studiomedico.model.SediEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SedeMapper {

    SediEntity toEntity(SedeRequestDTO dto);

    SedeResponseDTO toResponseDTO(SediEntity entity);

    List<SedeResponseDTO> toResponseDTOList(List<SediEntity> entities);
}

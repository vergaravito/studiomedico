package it.bvsolution.studiomedico.mapper;

import it.bvsolution.studiomedico.dto.incarichi.IncaricoRequestDTO;
import it.bvsolution.studiomedico.dto.incarichi.IncaricoResponseDTO;
import it.bvsolution.studiomedico.model.IncarichiEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IncaricoMapper {

    IncarichiEntity toEntity(IncaricoRequestDTO dto);

    IncaricoResponseDTO toResponseDTO(IncarichiEntity entity);

    List<IncaricoResponseDTO> toResponseDTOList(List<IncarichiEntity> entities);
}

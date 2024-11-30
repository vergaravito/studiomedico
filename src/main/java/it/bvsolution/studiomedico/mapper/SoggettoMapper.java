package it.bvsolution.studiomedico.mapper;

import it.bvsolution.studiomedico.dto.soggetti.SoggettoRequestDTO;
import it.bvsolution.studiomedico.dto.soggetti.SoggettoResponseDTO;
import it.bvsolution.studiomedico.model.SoggettiEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SoggettoMapper {

    SoggettiEntity toEntity(SoggettoRequestDTO dto);

    SoggettoResponseDTO toResponseDTO(SoggettiEntity entity);

    List<SoggettoResponseDTO> toResponseDTOList(List<SoggettiEntity> entities);
}

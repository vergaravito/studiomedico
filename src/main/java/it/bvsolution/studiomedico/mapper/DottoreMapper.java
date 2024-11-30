package it.bvsolution.studiomedico.mapper;

import it.bvsolution.studiomedico.dto.dottori.DottoreRequestDTO;
import it.bvsolution.studiomedico.dto.dottori.DottoreResponseDTO;
import it.bvsolution.studiomedico.model.DottoriEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DottoreMapper {

    DottoriEntity toEntity(DottoreRequestDTO dto);

    DottoreResponseDTO toResponseDTO(DottoriEntity entity);

    List<DottoreResponseDTO> toResponseDTOList(List<DottoriEntity> entities);
}

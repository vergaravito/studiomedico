package it.bvsolution.studiomedico.mapper;

import it.bvsolution.studiomedico.dto.avvocati.AvvocatoRequestDTO;
import it.bvsolution.studiomedico.dto.avvocati.AvvocatoResponseDTO;
import it.bvsolution.studiomedico.model.AvvocatiEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AvvocatoMapper {

    AvvocatiEntity toEntity(AvvocatoRequestDTO dto);

    AvvocatoResponseDTO toResponseDTO(AvvocatiEntity entity);

    List<AvvocatoResponseDTO> toResponseDTOList(List<AvvocatiEntity> entities);
}

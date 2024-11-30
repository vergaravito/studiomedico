package it.bvsolution.studiomedico.mapper;

import it.bvsolution.studiomedico.dto.assicurazioni.AssicurazioneRequestDTO;
import it.bvsolution.studiomedico.dto.assicurazioni.AssicurazioneResponseDTO;
import it.bvsolution.studiomedico.model.AssicurazioniEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssicurazioneMapper {

    AssicurazioniEntity toEntity(AssicurazioneRequestDTO dto);

    AssicurazioneResponseDTO toResponseDTO(AssicurazioniEntity entity);

    List<AssicurazioneResponseDTO> toResponseDTOList(List<AssicurazioniEntity> entities);
}

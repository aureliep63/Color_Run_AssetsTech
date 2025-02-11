package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Role;
import org.mapstruct.Mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);
}

package fr.hb.color_run.service;

import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> getRoles();

    RoleDto getRoleById(Long id);

    Role saveRole(RoleDto roleDto);

    void deleteRole(Long id);
}

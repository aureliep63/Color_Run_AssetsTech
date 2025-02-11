package fr.hb.color_run.controller.rest;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Parcours;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Validated
public class RoleControllerRest {

    private RoleService roleService;

    public RoleControllerRest(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public List<RoleDto> getAllRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Role saveRole(@Valid @RequestBody RoleDto roleDto) {
        return roleService.saveRole(roleDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @Valid @RequestBody RoleDto roleDto) {
        roleDto.setId(id);
        return roleService.saveRole(roleDto);
    }
}

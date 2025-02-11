package fr.hb.color_run.service.Impl;

import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.mapper.RoleMapper;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.repository.RoleRepository;
import fr.hb.color_run.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    private RoleDto roleDto;

    @Override
    public List<RoleDto> getRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(roleMapper::toDto)
                .orElse(null);
    }

    @Override
    public Role saveRole(RoleDto roleDto) {
        Role role = roleMapper.toEntity(roleDto);
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}

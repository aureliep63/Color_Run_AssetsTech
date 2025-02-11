package fr.hb.color_run.controller;

import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping("/vueRoles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String listRoles(Model model, Locale locale) {
        model.addAttribute("roles", roleService.getRoles());
        return "role/list";
    }

    @GetMapping("/add")
    public String addRoleForm(Model model) {
        model.addAttribute("isEditMode", false);
        model.addAttribute("role", new Role());
        return "role/form";
    }

    @GetMapping("/edit/{id}")
    public String editRoleForm(@PathVariable("id") Long id, Model model) {
        RoleDto existing = roleService.getRoleById(id);
        if (existing == null) {
            return "redirect:/vueRoles";
        }
        model.addAttribute("isEditMode", true);
        model.addAttribute("role", existing);
        return "role/form";
    }

    @PostMapping("")
    public String saveRole(@Valid @ModelAttribute("role") RoleDto roleDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEditMode", roleService.getRoleById(roleDto.getId()) != null);
            return "role/form";
        }
        roleService.saveRole(roleDto);
        return "redirect:/vueRoles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
        return "redirect:/vueRoles";
    }
}

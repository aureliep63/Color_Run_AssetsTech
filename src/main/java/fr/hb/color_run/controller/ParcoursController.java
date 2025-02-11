package fr.hb.color_run.controller;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.dto.RoleDto;
import fr.hb.color_run.model.Parcours;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.service.ParcoursService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping("/vueParcours")
public class ParcoursController {

    @Autowired
    private ParcoursService parcoursService;

    @GetMapping("")
    public String listParcours(Model model, Locale locale) {
        model.addAttribute("parcours", parcoursService.getParcours());
        return "vueParcours/list";
    }

    @GetMapping("/add")
    public String addParcoursForm(Model model) {
        model.addAttribute("isEditMode", false);
        model.addAttribute("parcours", new Parcours());
        return "parcours/form";
    }

    @GetMapping("edit/{id}")
    public String editParcoursForm(@PathVariable("id") Long id, Model model) {
        ParcoursDto existing = parcoursService.getParcoursById(id);
        if (existing == null) {
            return "redirect:/vueParcours";
        }
        model.addAttribute("isEditMode", true);
        model.addAttribute("parcours", existing);
        return "parcours/form";
    }

    @PostMapping("")
    public String saveParcours(@Valid @ModelAttribute("parcours") ParcoursDto parcoursDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEditMode", parcoursService.getParcoursById(parcoursDto.getId()) != null);
            return "parcours/form";
        }
        parcoursService.saveParcours(parcoursDto);
        return "redirect:/vueParcours";
    }

    @GetMapping("/delete/{id}")
    public String deleteParcours(@PathVariable("id") Long id) {
        parcoursService.deleteParcoursById(id);
        return "redirect:/vueParcours";
    }
}

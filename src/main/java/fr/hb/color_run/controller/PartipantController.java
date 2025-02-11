package fr.hb.color_run.controller;

import fr.hb.color_run.dto.ProfilParticipantDto;
import fr.hb.color_run.model.Participant;
import fr.hb.color_run.service.ParticipantService;
import fr.hb.color_run.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping("/vueParticipants")
public class PartipantController {
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String listParticipants(Model model, Locale locale) {
        model.addAttribute("participants", participantService.getParticipants());
        model.addAttribute("roles", roleService.getRoles());
        return "participant/list";
    }

    @GetMapping("/add")
    public String addParticipantForm(Model model) {
        model.addAttribute("isEditMode", false);
        model.addAttribute("participant", new Participant());
        return "participant/form";
    }

    @GetMapping("/edit/{id}")
    public String editParticipantForm(@PathVariable("id") Long id, Model model) {
        ProfilParticipantDto existing = participantService.getParticipantById(id);
        if (existing == null) {
            return "redirect:/vueParticipants";
        }
        model.addAttribute("isEditMode", true);
        model.addAttribute("participant", existing);
        return "participant/form";
    }

    @PostMapping("")
    public String saveParticipant(@Valid @ModelAttribute("participant") ProfilParticipantDto participantDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEditMode", participantService.getParticipantById(participantDto.getId()) != null);
            return "participant/form";
        }
        participantService.saveParticipant(participantDto);
        return "redirect:/vueParticipants";
    }

    @GetMapping("/delete/{id}")
    public String deleteParticipant(@PathVariable("id") Long id) {
        participantService.deleteParticipant(id);
        return "redirect:/vueParticipants";
    }
}

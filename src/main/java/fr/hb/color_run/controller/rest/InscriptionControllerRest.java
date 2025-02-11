package fr.hb.color_run.controller.rest;

import fr.hb.color_run.dto.InscriptionDto;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.service.InscriptionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
@Validated
public class InscriptionControllerRest {

    private InscriptionService inscriptionService;
    public InscriptionControllerRest(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping("")
    public List<InscriptionDto> getAllInscriptions() {
        return inscriptionService.getInscriptions();
    }

    @GetMapping("/{id}")
    public InscriptionDto getInscriptionById(@PathVariable Long id) {
        return inscriptionService.getInscriptionById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Inscription saveInscription(@Valid @RequestBody InscriptionDto inscriptionDto) {
        return inscriptionService.saveInscription(inscriptionDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
    }

    @PutMapping("/{id}")
    public Inscription updateInscription(@PathVariable Long id,@Valid @RequestBody InscriptionDto inscriptionDto) {
        inscriptionDto.setId(id);
        return inscriptionService.saveInscription(inscriptionDto);
    }
}

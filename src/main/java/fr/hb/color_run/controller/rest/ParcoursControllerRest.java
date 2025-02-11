package fr.hb.color_run.controller.rest;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.model.Parcours;
import fr.hb.color_run.service.ParcoursService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcours")
@Validated
public class ParcoursControllerRest {

    private ParcoursService parcoursService;
    public ParcoursControllerRest(ParcoursService parcoursService) {
        this.parcoursService = parcoursService;
    }

    @GetMapping("")
    public List<ParcoursDto> getAllParcours() {
        return parcoursService.getParcours();
    }

    @GetMapping("/{id}")
    public ParcoursDto getParcoursById(@PathVariable Long id) {
        return parcoursService.getParcoursById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Parcours saveParcours(@Valid @RequestBody ParcoursDto parcoursDto) {
        return parcoursService.saveParcours(parcoursDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteParcours(@PathVariable Long id) {
        parcoursService.deleteParcoursById(id);
    }

    @PutMapping("/{id}")
    public Parcours updateParcours(@PathVariable Long id, @Valid @RequestBody ParcoursDto parcoursDto) {
        parcoursDto.setId(id);
        return parcoursService.saveParcours(parcoursDto);
    }
}

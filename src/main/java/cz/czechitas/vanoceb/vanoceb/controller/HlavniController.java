package cz.czechitas.vanoceb.vanoceb.controller;

import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import cz.czechitas.vanoceb.vanoceb.dto.*;
import cz.czechitas.vanoceb.vanoceb.entity.*;
import cz.czechitas.vanoceb.vanoceb.form.*;
import cz.czechitas.vanoceb.vanoceb.service.*;

@RestController
@CrossOrigin
@RequestMapping

public class HlavniController {

    private PraniService praniService;

    public HlavniController (PraniService praniService) {
        this.praniService = praniService;
    }

    @GetMapping("/moje-prani")
    public Iterable<PraniDTO> mojePrani() {
        return praniService.getMojePrani();
    }

    @GetMapping("/ostatni-prani")
    public Iterable<PraniDTO> ostatniPrani() {
        return praniService.getOstatniPrani();
    }

    @PostMapping("/pridat-prani")
    @ResponseStatus(HttpStatus.CREATED)
    public void pridatPrani(@RequestBody PraniForm praniForm) {
        praniService.save(praniForm);
    }

    @PostMapping("/smazat-prani")
    public void smazatPrani(Long id) {
        praniService.delete(id);
    }



}

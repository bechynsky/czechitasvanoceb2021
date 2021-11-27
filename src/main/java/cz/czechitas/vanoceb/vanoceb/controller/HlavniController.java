package cz.czechitas.vanoceb.vanoceb.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import cz.czechitas.vanoceb.vanoceb.dto.*;
import cz.czechitas.vanoceb.vanoceb.entity.*;
import cz.czechitas.vanoceb.vanoceb.service.*;

@RestController
@CrossOrigin
@RequestMapping("")

public class HlavniController {

    private PraniService praniService;

    public HlavniController (PraniService praniService) {
        this.praniService = praniService;
    }

    @GetMapping(value = "/moje-prani")
    public Iterable<PraniDTO> mojePrani() {
        return praniService.getMojePrani();
    }
            

 




}

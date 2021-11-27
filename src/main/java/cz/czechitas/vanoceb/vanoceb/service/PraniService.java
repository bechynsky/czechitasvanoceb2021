package cz.czechitas.vanoceb.vanoceb.service;

import java.util.*;
import java.util.stream.*;
import org.springframework.stereotype.*;
import cz.czechitas.vanoceb.vanoceb.dto.*;
import cz.czechitas.vanoceb.vanoceb.entity.*;
import cz.czechitas.vanoceb.vanoceb.form.*;
import cz.czechitas.vanoceb.vanoceb.persistence.*;

@Service

public class PraniService implements IPraniService {

    private final PraniRepository praniRepository;
    private final UzivatelRepository uzivatelRepository;

    public PraniService(PraniRepository praniRepository, UzivatelRepository uzivatelRepository) {
        this.praniRepository = praniRepository;
        this.uzivatelRepository = uzivatelRepository;
    }


    @Override
    public Iterable<PraniDTO> getMojePrani() {
        Iterable<Prani> praniIterable = praniRepository.findByProKoho_Id(aktualniPrihlasenyUzivatel());
        return StreamSupport.stream(praniIterable.spliterator(), false)
                .map(this::praniConvert)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<PraniDTO> getOstatniPrani() {
        Iterable<Prani> praniIterable = praniRepository.findByProKoho_IdNot(aktualniPrihlasenyUzivatel());
        return StreamSupport.stream(praniIterable.spliterator(), false)
                .map(this::praniConvert)
                .collect(Collectors.toList());
    }

    @Override
    public void save(PraniForm novePrani) {
        Prani pridanePrani = new Prani();
        Optional<Uzivatel> uzivatel = uzivatelRepository.findById(novePrani.getJmenoId());
        pridanePrani.setProKoho(uzivatel.get());
        pridanePrani.setNazevPrani(novePrani.getNazevPrani());
        praniRepository.save(pridanePrani);
    }

    @Override
    public void delete(Long id) {
        praniRepository.deleteById(id);
    }

    private Long aktualniPrihlasenyUzivatel() {
        return 1L;
    }

    private PraniDTO praniConvert (Prani prani) {
        PraniDTO praniDTO = new PraniDTO();
        praniDTO.setJmenoProKoho(prani.getProKoho().getJmeno());
        praniDTO.setNazevPrani(prani.getNazevPrani());
        if (prani.getNavrhl() != null) {
            praniDTO.setJmenoNavrhl(prani.getNavrhl().getJmeno());
        }
        if (prani.getKupuje() != null) {
            praniDTO.setJmenoKupuje(prani.getKupuje().getJmeno());
        }
        return praniDTO;

    }




}

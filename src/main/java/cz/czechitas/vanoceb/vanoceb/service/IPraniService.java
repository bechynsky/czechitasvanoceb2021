package cz.czechitas.vanoceb.vanoceb.service;

import cz.czechitas.vanoceb.vanoceb.dto.*;
import cz.czechitas.vanoceb.vanoceb.form.*;

public interface IPraniService {

    public Iterable<PraniDTO> getMojePrani();

    public Iterable<PraniDTO> getOstatniPrani();

    public void save(PraniForm novePrani);

    public void delete(Long id);





}

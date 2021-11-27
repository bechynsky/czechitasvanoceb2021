package cz.czechitas.vanoceb.vanoceb.persistence;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import cz.czechitas.vanoceb.vanoceb.entity.*;

@Repository
public interface UzivatelRepository extends CrudRepository<Uzivatel, Long> {


}

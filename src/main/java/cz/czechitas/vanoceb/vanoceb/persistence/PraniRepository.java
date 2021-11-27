package cz.czechitas.vanoceb.vanoceb.persistence;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
import cz.czechitas.vanoceb.vanoceb.entity.*;

@Repository
public interface PraniRepository extends CrudRepository<Prani, Long>  {

    Iterable<Prani> findByProKoho_Id(Long uzivatelId);
    Iterable<Prani> findByProKoho_IdNot(Long uzivatelId);
    


}

package link.redefine.api.rdfn.repository;

import link.redefine.api.rdfn.entity.Country;
import link.redefine.api.rdfn.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("select v from Visit v where v.countryByIdCountry.idCountry = :idCountry")
    public List<Visit> findVisitsByIdCountry(@Param(value = "idCountry") Integer idCountry);

}

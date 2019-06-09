package link.redefine.api.rdfn.service;

import link.redefine.api.rdfn.entity.Country;
import link.redefine.api.rdfn.entity.Visit;
import link.redefine.api.rdfn.exception.CountryNotFoundException;
import link.redefine.api.rdfn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findById(Integer id) {

        Optional<Country> country = countryRepository.findById(id);

        if (country.isPresent()) {
            return country.get();
        } else {
            throw new CountryNotFoundException();
        }
    }

    public List<Visit> findVisitsByIdCountry(Integer idCountry) {
        return countryRepository.findVisitsByIdCountry(idCountry);
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }

}

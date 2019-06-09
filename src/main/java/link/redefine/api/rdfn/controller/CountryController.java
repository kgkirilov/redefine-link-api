package link.redefine.api.rdfn.controller;

import link.redefine.api.rdfn.entity.Country;
import link.redefine.api.rdfn.entity.Visit;
import link.redefine.api.rdfn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(path = "/countries")
    public List<Country> getCountries() {
        return countryService.findAll();
    }

    @GetMapping(path = "/countries/{id}")
    public Country getCountryById(@PathVariable Integer id) {
        return countryService.findById(id);
    }

    @GetMapping(path = "/countries/{id}/visits")
    public List<Visit> getVisitsByCountry(@PathVariable Integer id) {
        return countryService.findVisitsByIdCountry(id);
    }

    @PostMapping(path = "/countries")
    public ResponseEntity<Object> createCountry(@Valid @RequestBody Country country) {

        Country savedCountry = countryService.save(country);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCountry.getIdCountry())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/countries")
    public void updateCountry(@Valid @RequestBody Country country) {
        countryService.save(country);
    }

    @DeleteMapping(path = "/countries/{id}")
    public void deleteCountry(@PathVariable Integer id) {
        countryService.deleteById(id);
    }

}

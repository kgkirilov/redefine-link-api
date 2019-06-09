package link.redefine.api.rdfn.controller;

import link.redefine.api.rdfn.entity.Visit;
import link.redefine.api.rdfn.exception.VisitNotFoundException;
import link.redefine.api.rdfn.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class VisitController {

    @Autowired
    VisitService visitService;

    @GetMapping(path = "/visits/{id}")
    public Visit getVisit(@PathVariable Integer id) {
        return visitService.findById(id);
    }

    @DeleteMapping(path = "visits/{id}")
    public void deleteById(@PathVariable Integer id) {
        visitService.deleteById(id);
    }

}

package link.redefine.api.rdfn.controller;

import link.redefine.api.rdfn.entity.Url;
import link.redefine.api.rdfn.repository.UrlRepository;
import link.redefine.api.rdfn.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class UrlController {

    @Autowired
    UrlService urlService;

    @GetMapping(path = "/urls")
    public List<Url> getUrls() {
        return urlService.findAll();
    }

    @GetMapping(path = "/urls/{id}")
    public Url getUrl(@PathVariable Integer id) {
        return urlService.findById(id);
    }

    @GetMapping(path = "urls/{id}/visits")
    public Integer getUrlVisitsCount(@PathVariable Integer id) {
        return urlService.findUrlVisitsCount(id);
    }

    @PostMapping(path = "/urls")
    public ResponseEntity<Object> createUrl(@Valid @RequestBody Url url) {
        Date date = new Date();
        url.setCreated(new Timestamp(date.getTime()));

        Url savedUrl = urlService.save(url);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUrl.getIdUrl())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping(path = "/urls")
    public void updateUrl(@Valid @RequestBody Url url) {
        urlService.save(url);
    }

    @DeleteMapping(path = "/urls/{id}")
    public void deleteUrl(@PathVariable Integer id) {
        urlService.deleteById(id);
    }


}

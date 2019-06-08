package link.redefine.api.rdfn.controller;

import link.redefine.api.rdfn.entity.Domain;
import link.redefine.api.rdfn.entity.Url;
import link.redefine.api.rdfn.entity.User;
import link.redefine.api.rdfn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/users/{id}/urls")
    public List<Url> getUserUrls(@PathVariable Integer id) {
        return userService.getUserUrls(id);
    }

    @GetMapping(path = "/users/{id}/domains")
    public List<Domain> getUserDomains(@PathVariable Integer id) {
        return userService.getUserDomains(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        Date date = new Date();
        user.setCreated(new Timestamp(date.getTime()));
        user.setUpdated(new Timestamp(date.getTime()));

        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getIdUser())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping(path = "/users")
    public void updateUser(@Valid @RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

}

package br.juliodias.peoplemanagement.controller;

import br.juliodias.peoplemanagement.model.People;
import br.juliodias.peoplemanagement.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping
    public ResponseEntity addPeople(@RequestBody People people) {
        try {
            peopleService.addPeople(people);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping()
    public ResponseEntity updatePeople(@RequestBody People people) {
        try {
            peopleService.updatePeople(people);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public List<People> getAllPeople() {
        return peopleService.getAllPeople();
    }

    @GetMapping("/id/{id}")
    public People getPeopleById(@PathVariable String id) {
        return peopleService.getPeopleById(id);
    }

    @GetMapping("/name/{name}")
    public List<People> getPeopleByName(@PathVariable String name) {
        // TODO: handle null or empty list
        return peopleService.getPeopleByName(name);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deletePeople(@PathVariable String id) {
        // TODO: handle when the entry isn't found.
        try {
            peopleService.deletePeople(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

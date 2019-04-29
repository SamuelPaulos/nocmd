package com.cognizant.restpractice.controller;

import com.cognizant.restpractice.model.Person;
import com.cognizant.restpractice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Person>  getById(@PathVariable String id){
        Person person = personService.getPersonById(id);
        if (person == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/addperson")
    public @ResponseBody ResponseEntity<Boolean> addPerson(@RequestBody Person person){
        boolean result = personService.addPersonList(person);
        if (!result){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<Person>> getAllPersonInList(){
        return new ResponseEntity<>(personService.getPersonList(), HttpStatus.OK);
    }
}

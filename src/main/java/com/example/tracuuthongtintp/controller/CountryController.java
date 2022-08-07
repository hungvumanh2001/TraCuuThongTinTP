package com.example.tracuuthongtintp.controller;

import com.example.tracuuthongtintp.model.Country;
import com.example.tracuuthongtintp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/countries")
@CrossOrigin("*")
public class CountryController {
    @Autowired
    CountryRepository countryRepository;
    @PostMapping
    public ResponseEntity save(@RequestBody Country country){
        return new ResponseEntity(countryRepository.save(country), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(countryRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(countryRepository.findById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Country country){
        Optional<Country> oldCountry = countryRepository.findById(id);
        if(!oldCountry.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        country.setId(id);
        countryRepository.save(country);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        countryRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

package com.example.tracuuthongtintp.controller;

import com.example.tracuuthongtintp.model.City;
import com.example.tracuuthongtintp.model.Country;
import com.example.tracuuthongtintp.repository.CityRepository;
import com.example.tracuuthongtintp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cities")
@CrossOrigin("*")
public class CityController {
    @Autowired
    CityRepository cityRepository;
    @PostMapping
    public ResponseEntity save(@RequestBody City city){
        return new ResponseEntity(cityRepository.save(city), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(cityRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(cityRepository.findById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody City city){
        Optional<City> oldCity = cityRepository.findById(id);
        if(!oldCity.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        city.setId(id);
        cityRepository.save(city);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        cityRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

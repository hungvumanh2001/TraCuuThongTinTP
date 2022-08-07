package com.example.tracuuthongtintp.model;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double areaTotal;
    private Long population;
    private Long gdpTotal;
    private String description;
    @ManyToOne
    private Country country;

    public City() {
    }

    public City(Long id, String name, double areaTotal, Long population, Long gdpTotal, String description, Country country) {
        this.id = id;
        this.name = name;
        this.areaTotal = areaTotal;
        this.population = population;
        this.gdpTotal = gdpTotal;
        this.description = description;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGdpTotal() {
        return gdpTotal;
    }

    public void setGdpTotal(Long gdpTotal) {
        this.gdpTotal = gdpTotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

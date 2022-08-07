package com.example.tracuuthongtintp.repository;

import com.example.tracuuthongtintp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Long, Country> {
}

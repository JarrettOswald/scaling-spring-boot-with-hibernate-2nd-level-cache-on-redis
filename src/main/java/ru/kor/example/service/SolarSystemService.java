package ru.kor.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kor.example.dto.Planet;
import ru.kor.example.repository.PlanetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SolarSystemService {
    @Autowired
    private PlanetRepository planetRepository;

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    public void savePlanet(Planet planet) {
        planetRepository.save(planet);
    }

    public Optional<Planet> getPlanetById(long id) {
        return planetRepository.findById(id);
    }
}

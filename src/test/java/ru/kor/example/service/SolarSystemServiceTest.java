package ru.kor.example.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.kor.example.dto.Planet;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Slf4j
@SpringBootTest
class SolarSystemServiceTest {

    @Autowired
    SolarSystemService planetService;

    private Planet readPlanet(long id) {
        log.info(String.format("query planet #%d", id));
        Optional<Planet> planet = planetService.getPlanetById(id);
        assertTrue(planet.isPresent());
        log.info("planet found");
        return planet.get();
    }

    @Test
    @Transactional
    void testReadPlanet() {
        Planet planet = readPlanet(4);
        //assert that the 4th planet is 'Mars'
        log.info("Planet name: {}",planet.getName());
        assertEquals("Mars", planet.getName());
    }

    @Test
    @Transactional
    void testReadMoonFromPlanet() {
        Planet planet = readPlanet(4);
        assertEquals(2, planet.getMoons().size());
    }

    @Test
    @Transactional
    void testReadPlanetThreeTimes() {
        testReadPlanet();
        testReadPlanet();
        testReadPlanet();
    }


    @Test
    @Transactional
    void testUpdatePlanet() {
        Planet planet = readPlanet(4);
        planet.setName("Mars2");
        planetService.savePlanet(planet);

        Planet planet2 = readPlanet(4);
        log.info("planet2 name: {}", planet2.getName());
        assertEquals("Mars2", planet2.getName());
    }
}
package ru.kor.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kor.example.dto.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}

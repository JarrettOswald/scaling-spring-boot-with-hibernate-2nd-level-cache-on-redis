package ru.kor.example.dto;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Set;

@Entity
@Table(name = "planets")
@Getter
@Setter
@ToString
@org.hibernate.annotations.Cache(region = "planetCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Planet {
    @Id
    private long id;
    private String name;
    private String type;
    private float mass;
    private int diameter;
    private float distance;
    @OneToMany(mappedBy = "planet", cascade = CascadeType.ALL)
    private Set<Moon> moons;
}
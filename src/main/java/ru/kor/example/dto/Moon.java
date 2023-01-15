package ru.kor.example.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "moons")
@Getter
@Setter
@ToString
public class Moon {

    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;
    private String name;
    private int diameter;
}

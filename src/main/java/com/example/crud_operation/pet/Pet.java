package com.example.crud_operation.pet;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity//Tells hibernate that this class is going to serve as table in database
@Table(name="pet")
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String color;

    public Pet(String name, String color) {
        this.name = name;
        this.color = color;
    }
}

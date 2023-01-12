package com.example.youbookingweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String imageUrl ;
    private int capacity ;
    private int numberRoom ;

    private String description ;
    private String option;
    private Double price ;
    @ManyToOne
    private Hotel hotel ;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", numberRoom=" + numberRoom +
                ", option='" + option + '\'' +
                ", price=" + price +
                ", hotel=" + hotel +
                '}';
    }
}

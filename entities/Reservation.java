package com.example.youbookingweb.entities;

import com.example.youbookingweb.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private double totalPrice ;
    private Date startDate ;
    private Date endDate ;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client ;

    @ManyToOne
    private Room room;

    @Enumerated(EnumType.STRING)
    private Status status ;


}
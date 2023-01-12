package com.example.youbookingweb.ressources;

import com.example.youbookingweb.entities.Reservation;
import com.example.youbookingweb.entities.User;
import com.example.youbookingweb.services.ReservationService;
import com.example.youbookingweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ReservationResource {

    @Autowired
    ReservationService reservationService;

    @GetMapping(path = "/Reservations")
    public ResponseEntity<List<Reservation>> GatAllRes(){
        List<Reservation> reservations = reservationService.GetAllRes();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/Reservations/{id}")
    public ResponseEntity<Reservation> GetResById(@PathVariable("id") long id){
        Optional<Reservation> reservationOptional = reservationService.findById(id);
        if(reservationOptional.isPresent()){
            return new ResponseEntity<>(reservationOptional.get() , HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

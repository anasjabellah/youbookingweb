package com.example.youbookingweb.ressources;

import com.example.youbookingweb.entities.Reservation;
import com.example.youbookingweb.entities.User;
import com.example.youbookingweb.services.ReservationService;
import com.example.youbookingweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/Reservations")
public class ReservationResource {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> GatAllRes(){
        List<Reservation> reservations = reservationService.getAllReservation();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Reservation> GetResById(@PathVariable("id") long id){
        Optional<Reservation> reservationOptional = reservationService.findById(id);
        if(reservationOptional.isPresent()){
            return new ResponseEntity<>(reservationOptional.get() , HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/allReservation/{id}")
    public ResponseEntity<List<Reservation>>  GetAllByUser(@PathVariable("id") long id){
        List<Reservation> reservationList = reservationService.GetAllByUser(id);
        return ResponseEntity.ok(reservationList);
    }


    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletRes(@PathVariable("id") Long id){
        reservationService.DeleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<?> updet(){
        return null ;
    }



}

package com.example.youbookingweb.ressources;


import com.example.youbookingweb.entities.Hotel;
import com.example.youbookingweb.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Hotels")
public class HotelResource {

    @Autowired
    HotelService hotelService ;

    @GetMapping(path = "/All")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = hotelService.GetAllHotels() ;
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Hotel> GetResById(@PathVariable("id") long id){
        Optional<Hotel> HotelId = hotelService.findById(id);
        if(HotelId.isPresent()){
            return new ResponseEntity<>(HotelId.get() , HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/add/{idManadger}")
    public Hotel save(@RequestBody Hotel hotel , @PathVariable Long idManadger) {
        return hotelService.addHotel(hotel,idManadger);
    }
    
    @PutMapping("/update/{idHotel}")
    public Hotel update(@RequestBody Hotel hotel , @PathVariable Long idHotel) {
        return hotelService.updateHotel(hotel , idHotel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deletHotel(@PathVariable("id") Long id){
        hotelService.DeleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

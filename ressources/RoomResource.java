package com.example.youbookingweb.ressources;

import com.example.youbookingweb.entities.Hotel;
import com.example.youbookingweb.entities.Room;
import com.example.youbookingweb.entities.User;
import com.example.youbookingweb.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(path = "/room")
public class RoomResource {

    @Autowired
    RoomService roomService;


    @GetMapping(path = "/All")
    public ResponseEntity<List<Room>> getAllHotels(){
        List<Room> rooms  = roomService.GetAllRoom() ;
        return ResponseEntity.ok(rooms);
    }

    @PostMapping("/add/{idHotel}")
    public Room save(@RequestBody Room room , @PathVariable Long idHotel) {
        return roomService.AddRoom(room,idHotel);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Room> GetResById(@PathVariable("id") long id){
        Optional<Room> RoomID = roomService.findByid(id);
        if(RoomID.isPresent()){
            return new ResponseEntity<>(RoomID.get() , HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(path = "/findRoom/{id}")
    public ResponseEntity<List<Room>> findByHotel(@PathVariable Long id){
        List<Room> allRoomByHotel = roomService.findByHotelId(id);
        return ResponseEntity.ok(allRoomByHotel);
    }

    @PostMapping("/update/{idRoom}")
    public Room update(@RequestBody  Room room , @PathVariable Long idRoom) {
        return roomService.updateRoom(room , idRoom);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deletRoom(@PathVariable("id") Long id){
        roomService.Delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

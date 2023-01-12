package com.example.youbookingweb.ressources;

import com.example.youbookingweb.entities.User;
import com.example.youbookingweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/users")
@RestController
public class UserResource {

    @Autowired
    UserService userService ;

    @GetMapping(path = "/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.GetAllUser();
        return ResponseEntity.ok(users);
    }


    @GetMapping(path = "/list/{banned}")
    public ResponseEntity<List<User>> findAllByBanned(@PathVariable Boolean banned){
        List<User> allByBanned = userService.findAllByBanned(banned);
        return ResponseEntity.ok(allByBanned);
    }
}

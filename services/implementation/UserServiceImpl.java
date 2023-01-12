package com.example.youbookingweb.services.implementation;

import com.example.youbookingweb.entities.Reservation;
import com.example.youbookingweb.entities.Role;
import com.example.youbookingweb.entities.User;
import com.example.youbookingweb.enumeration.Status;
import com.example.youbookingweb.repositories.UserRepository;
import com.example.youbookingweb.services.ReservationService;
import com.example.youbookingweb.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ReservationService reservationService ;

    public UserServiceImpl(UserRepository userRepository, ReservationService reservationService) {
        this.userRepository = userRepository;
        this.reservationService = reservationService;
    }

    @Override
    public void AddUser(User user) {
        if (user.getUserName() == null &&  user.getEmail() == null && user.getPassword() == null ){
            System.out.println("data is null");
        }else {
            userRepository.save(user);
        }
    }

    @Override
    public List<User> GetAllUser() {
        return userRepository.findAll();
    }

    @Override
     public Optional<User> findByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(User user , Long id) {
        User user1 = userRepository.findById(id).orElse(null);
        user1.setUserName(user.getUserName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        userRepository.save(user1)
        ;}


    @Override
    public void AccepterReservation(Long id) {

        Reservation reservation = reservationService.findById(id).orElse(null);
        if(reservation != null){
            System.out.println("reservation is null ");
        }else {
            reservation.setStatus(Status.Accepter);
        }

    }


    @Override
    public Boolean DeleteUser(long id) {
        userRepository.deleteById(id);

        if(userRepository.findById(id) != null){
            return Boolean.FALSE ;
        }else {
            return Boolean.TRUE ;
        }

    }


    @Override
    public void addUserRool(Long userId, Role role) {
        User user = userRepository.findById(userId).orElse(null);
        user.getRoles().add(role);
    }

    @Override
    public Boolean isBanned(Long id) {
        User user  = userRepository.findById(id).orElse(null);
        user.setBanned(false);
        if (user.isBanned() != false){
            System.out.println("is not baned");
            return false ;
        }
        return true ;
    }


    @Override
    public List<User> findAllByBanned(boolean banned) {
        return userRepository.findAllByBanned(banned);
    }
}

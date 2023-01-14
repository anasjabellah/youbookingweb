package com.example.youbookingweb.services.implementation;

import com.example.youbookingweb.entities.Reservation;
import com.example.youbookingweb.entities.Room;
import com.example.youbookingweb.entities.User;
import com.example.youbookingweb.enumeration.Status;
import com.example.youbookingweb.repositories.ReservationRepository;
import com.example.youbookingweb.repositories.RoomRepository;
import com.example.youbookingweb.repositories.UserRepository;
import com.example.youbookingweb.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired
    private final UserRepository userRepository ;
    @Autowired
    private final RoomRepository roomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }


    @Override
    public Reservation addReservation(Reservation reservation) {
            reservation.setStatus(Status.Encours);
            return reservationRepository.save(reservation);
    }


    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> GetAllByUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return reservationRepository.getReservationByClient(user);
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }


    @Override
    public Boolean DeleteReservation(long id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        reservationRepository.delete(reservation);
        return true ;
    }



}

package com.usa.retos.controller;

import com.usa.retos.entity.Reservation;
import com.usa.retos.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Reservation")
public class ReservationController {
    
     @Autowired
    private ReservationService service;
    
    @PostMapping("/save")
    public ResponseEntity addReservacion(@RequestBody Reservation reservacion){
        service.saveReservation(reservacion);
        return ResponseEntity.status(201).build();           
    }
    
    @GetMapping("/all")
    public List<Reservation> getAllResrvations(){
        return service.getReservationAll();
        
    }
    
    @PutMapping("/update")
   public ResponseEntity updateReservations(@RequestBody Reservation reservacion){
      service.updateReservation(reservacion);
      return ResponseEntity.status(201).build();          
   }
    
    @GetMapping("{id}")
    public Reservation findReservations(@PathVariable int id){
        return service.getReservationById(id);
    }
    
    @DeleteMapping("/{id}")
   public ResponseEntity deleteReservation(@PathVariable int id){
       service.deleteReservation(id);
       return ResponseEntity.status(204).build();
   }
}

package com.usa.retos.controller;

import com.usa.retos.service.GamesService;
import com.usa.retos.entity.Game;
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
@RequestMapping("/api/Game")
public class GamesController {
    
    @Autowired
    private GamesService servicio;
    
    @PostMapping("/save")
    public ResponseEntity addJuego(@RequestBody Game juego){
        servicio.saveGames(juego);
        return ResponseEntity.status(201).build();      
    }
    
   @GetMapping("/all")
   public List<Game> getAllJuegos(){
       return servicio.getGamesAll();
   }
   
   @GetMapping("{id}")
   public Game findGamesId(@PathVariable int id){
       return servicio.getGamesById(id);
   }
   
   @PutMapping("/update")
   public ResponseEntity updateJuego(@RequestBody Game juego){
      servicio.updateGames(juego);
      return ResponseEntity.status(201).build();
              
   }
   @DeleteMapping("/{id}")
   public ResponseEntity deleteGames(@PathVariable int id){
       servicio.deleteGames(id);
       return ResponseEntity.status(204).build();
   }
   
}
        
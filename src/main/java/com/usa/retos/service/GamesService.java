package com.usa.retos.service;

import com.usa.retos.entity.Game;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.retos.repository.GamesRepository;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
@Service
public class GamesService {
    @Autowired
    private GamesRepository repositorio;
    
    public Game saveGames(Game juego){
        return repositorio.save(juego);
    }

    public List<Game> getGamesAll(){
        return repositorio.findAll();
    }
    
    public Game updateGames(Game juego){
        Game existeJuego=repositorio.findById(juego.getId()).orElse(null);
        existeJuego.setName(juego.getName());
        existeJuego.setDeveloper(juego.getDeveloper());
        existeJuego.setYear(juego.getYear());
        existeJuego.setDescription(juego.getDescription());
        if(juego.getCategory()!= null){
            existeJuego.setCategory(juego.getCategory());
        }else{
            existeJuego.getCategory();
        }
        return repositorio.save(existeJuego);
    }
    
    public void deleteGames(int id){
        repositorio.deleteById(id);
    } 

    public Game getGamesById(int id){
        return repositorio.findById(id).orElse(null);
    }
}

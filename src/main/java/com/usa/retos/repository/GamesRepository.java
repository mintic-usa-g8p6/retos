/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.retos.repository;

import com.usa.retos.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
public interface GamesRepository extends JpaRepository<Game, Integer> {
    
}

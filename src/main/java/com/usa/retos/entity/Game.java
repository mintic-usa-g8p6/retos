package com.usa.retos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="game")
public class Game implements Serializable {
    /**
     * llave primaria y campos de informacion de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String developer;
    private int year;
    private String description;
    
    /**
     * variable categoria
     * Vinculacion uno a muchos en tabla category
     */
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties({"game","games"})
    private Category category;

    /**
     * variable mensajes
     * Vinculacion uno a muchos en tabla messages
     */    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="game")
    @JsonIgnoreProperties({"game","client"})
    private List<Message> messages;

    /**
     * variable reservaciones
     * Vinculacion uno a muchos en tabla reservations
     */    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="game")
    @JsonIgnoreProperties("game")
    private List<Reservation> reservations;
}

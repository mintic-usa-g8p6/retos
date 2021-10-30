package com.usa.retos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String email;
    private String password;
    private String name;
    private int age;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy ="client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;

    @OneToMany(cascade ={CascadeType.PERSIST}, mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;
   
    
    
}
    

    


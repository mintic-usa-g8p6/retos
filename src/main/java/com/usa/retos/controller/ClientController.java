package com.usa.retos.controller;

import com.usa.retos.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.usa.retos.service.ClientService;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientService servicio;
    
    @PostMapping("/save")
    public ResponseEntity addCliente(@RequestBody Client cliente){
        servicio.saveClient(cliente);
        return ResponseEntity.status(201).build();      
    }
    
   @GetMapping("/all")
   public List<Client> getAllClients(){
       return servicio.getClientAll();
   }
   
   @GetMapping("{id}")
   public Client findClientsById(@PathVariable int id){
       return servicio.getClientById(id);
   }
   
   @PutMapping("/update")
   public ResponseEntity updateClient(@RequestBody Client cliente){
      servicio.updateClient(cliente);
      return ResponseEntity.status(201).build();
              
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity deleteClient(@PathVariable int id){
       servicio.deleteClient(id);
       return ResponseEntity.status(204).build();
   }
       
}

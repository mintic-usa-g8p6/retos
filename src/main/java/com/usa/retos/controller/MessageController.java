package com.usa.retos.controller;

import com.usa.retos.entity.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.usa.retos.service.MessageService;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService servicio;
    
    @PostMapping("/save")
    public ResponseEntity addMensaje(@RequestBody Message mensaje){
        servicio.saveMessage(mensaje);
        return ResponseEntity.status(201).build();      
    }
    
   @GetMapping("/all")
   public List<Message> getAllMensajes(){
       return servicio.getMessageAll();
   }
    
   
   @GetMapping("{id}")
   public Message findMessagesById(@PathVariable int id){
       return servicio.getMessageById(id);
   }
   
   @PutMapping("/update")
   public ResponseEntity updateMessages(@RequestBody Message mensaje){
      servicio.updateMessage(mensaje);
      return ResponseEntity.status(201).build();          
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity deleteMessages(@PathVariable int idMessage){
       servicio.deleteMessage(idMessage);
       return ResponseEntity.status(204).build();
   }
}

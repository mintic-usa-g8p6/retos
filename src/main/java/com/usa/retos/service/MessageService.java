package com.usa.retos.service;

import com.usa.retos.entity.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.retos.repository.MessageRepository;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository repositorio;

    public Message saveMessage(Message mensaje){
        return repositorio.save(mensaje);
    }

    public List<Message> getMessageAll(){
        return repositorio.findAll();
    }

    public Message updateMessage(Message mensaje){
        Message existeMensaje=repositorio.findById(mensaje.getIdMessage()).orElse(null);
        //essage existeMensaje=getMessageById(mensaje.getIdMessage());
        existeMensaje.setMessageText(mensaje.getMessageText());
        return repositorio.save(existeMensaje);
    }

    public void deleteMessage(int idMessage){
        repositorio.deleteById(idMessage);
    }

    public Message getMessageById(int id){
        return repositorio.findById(id).orElse(null);
    }
}

    
    


package com.usa.retos.service;

import com.usa.retos.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.retos.repository.ClientRepository;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository repositorio;
    
    public Client saveClient(Client cliente){
        return repositorio.save(cliente);
    }
    
    public List<Client> getClientAll(){
        return repositorio.findAll();
    }
    
    public Client updateClient(Client cliente){
        Client existeCliente=repositorio.findById(cliente.getIdClient()).orElse(null);
        existeCliente.setName(cliente.getName());
        existeCliente.setEmail(cliente.getEmail());
        existeCliente.setAge(cliente.getAge());
        existeCliente.setPassword(cliente.getPassword());
        return repositorio.save(existeCliente);
    }
    
    public void deleteClient(int idClient){
        repositorio.deleteById(idClient);
    }

    public Client getClientById(int id){
        return repositorio.findById(id).orElse(null);
    }
}

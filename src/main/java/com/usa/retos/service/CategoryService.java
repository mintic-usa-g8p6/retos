package com.usa.retos.service;

import com.usa.retos.entity.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.retos.repository.CategoryRepository;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repositorio;
    
    public Category getCategoryById(int id){
        return repositorio.findById(id).orElse(null);
    }
    
    public Category saveCategory(Category categoria){
        return repositorio.save(categoria);
    }
    
    public List<Category> getCategoryAll(){
        return repositorio.findAll();
    }
    
    public Category updateCategory(Category categoria){
        Category existeCategoria=repositorio.findById(categoria.getId()).orElse(null);
        existeCategoria.setName(categoria.getName());
        existeCategoria.setDescription(categoria.getDescription());
        return repositorio.save(existeCategoria);
    }
        
    public void deleteCategory(int id){
       repositorio.deleteById(id);
    }
    
    
    
}

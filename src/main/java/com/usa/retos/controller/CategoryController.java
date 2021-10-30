package com.usa.retos.controller;

import com.usa.retos.entity.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.usa.retos.service.CategoryService;

/**
 * @author Omar Velez
 * Octubre 30 de 2021
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService service;
    
    @PostMapping("/save")
        public ResponseEntity addCategoria(@RequestBody Category categoria){
            service.saveCategory(categoria);
            return ResponseEntity.status(201).build();      
    }
    
    @GetMapping("/all")
        public List<Category> getAllCategorias(){
        return service.getCategoryAll();
   }
   
    @GetMapping("{id}")
        public Category findCategorysById(@PathVariable int id){
        return service.getCategoryById(id);
   }
   
    @PutMapping("/update")
        public ResponseEntity updateCategory(@RequestBody Category categoria){
        service.updateCategory(categoria);
        return ResponseEntity.status(201).build();
   }
   
    @DeleteMapping("/{id}")
        public ResponseEntity deleteCategory(@PathVariable int id){
        service.deleteCategory(id);
        return ResponseEntity.status(204).build();
   }
}

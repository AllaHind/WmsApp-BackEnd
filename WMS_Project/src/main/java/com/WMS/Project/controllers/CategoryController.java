package com.WMS.Project.controllers;


import com.WMS.Project.models.Categorie;
import com.WMS.Project.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/code/{code}")
    public Categorie findByCode(@PathVariable("code") String code) {
        return categorieService.findByCode(code);
    }
@PostMapping("/")
    public ResponseEntity<?> save(@RequestBody  Categorie categorie) {
        return categorieService.save(categorie);
    }
@GetMapping("/findAll")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }
@DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable("id") long id) {
        categorieService.deleteById(id);
    }
}

package com.WMS.Project.controllers;

import com.WMS.Project.models.Commande;
import com.WMS.Project.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }
@GetMapping("/findAll")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @GetMapping("/code/{code}")
    public Commande findByCode(@PathVariable("code") String code) {
        return commandeService.findByCode(code);
    }
}

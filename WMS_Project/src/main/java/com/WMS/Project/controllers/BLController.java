package com.WMS.Project.controllers;


import com.WMS.Project.models.BL;
import com.WMS.Project.services.BLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/BL")
public class BLController {
    @Autowired
    private BLService blService;

@PostMapping("/")
    public ResponseEntity<?> save(@RequestBody BL bl) {
        return blService.save(bl);
    }
@GetMapping("/findAll")
    public List<BL> findAll() {
        return blService.findAll();
    }
@GetMapping("/blNumero/{blNumero}")
    public BL findByBlNumero(@PathVariable("blNumero") String blNumero) {
        return blService.findByBlNumero(blNumero);
    }

@DeleteMapping("/id/{id}")
    public void deleteById(Long id) {
        blService.deleteById(id);
    }
}

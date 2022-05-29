package com.WMS.Project.controllers;


import com.WMS.Project.models.Attendu;
import com.WMS.Project.services.AttenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Attendu")
public class AttenduController {

    @Autowired
    private AttenduService attenduService;

    @GetMapping("/code/{code}")
    public Attendu findByCode(@PathVariable("code") String code) {
        return attenduService.findByCode(code);
    }
@PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Attendu attendu) {
        return attenduService.save(attendu);
    }
}

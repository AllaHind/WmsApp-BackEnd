package com.WMS.Project.controllers;

import com.WMS.Project.models.Emplacement;
import com.WMS.Project.repository.EmplacementRep;
import com.WMS.Project.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/code/{code}")
    public Emplacement findByCode(@PathVariable("code") String code) {
        return empService.findByCode(code);
    }


    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Emplacement emp) {
        return empService.save(emp);
    }

    @GetMapping("/findAll")
    public List<Emplacement> findAll() {
        return empService.findAll();
    }
}

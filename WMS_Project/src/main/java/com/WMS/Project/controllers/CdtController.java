package com.WMS.Project.controllers;

import com.WMS.Project.models.Conditionnement;
import com.WMS.Project.services.ConditionnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cdt")
public class CdtController {

    @Autowired
    private ConditionnementService conditionnementService;

    @GetMapping("/code/{code}")
    public Conditionnement findByCode(@PathVariable("code") String code) {
        return conditionnementService.findByCode(code);
    }
@PostMapping("/")
    public int save(@RequestBody Conditionnement cdt) {
        return conditionnementService.save(cdt);
    }
}

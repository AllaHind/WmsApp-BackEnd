package com.WMS.Project.controllers;


import com.WMS.Project.models.Article;
import com.WMS.Project.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Article")
public class ArticleControllers {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/code/{code}")
    public Article findByCode(@PathVariable("code") String code) {
        return articleService.findByCode(code);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Article article) {
        return articleService.save(article);
    }

    @GetMapping("/findAll")
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        articleService.deleteById(id);
    }

}

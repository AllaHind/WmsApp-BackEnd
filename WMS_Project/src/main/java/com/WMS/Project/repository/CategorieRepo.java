package com.WMS.Project.repository;

import com.WMS.Project.models.Categorie;
import com.WMS.Project.models.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategorieRepo extends JpaRepository<Categorie,Long> {

    Categorie findByCode(String code);
    Categorie findByNom(String nom);



}

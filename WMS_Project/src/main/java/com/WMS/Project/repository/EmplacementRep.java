package com.WMS.Project.repository;

import com.WMS.Project.models.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmplacementRep extends JpaRepository<Emplacement,Long> {
    Emplacement findByCode(String code);
    @Query("SELECT e FROM Emplacement e WHERE e.id = (SELECT  MAX(e.id) FROM  Emplacement e WHERE  e.status='vide' and e.niveau='00')")
    Emplacement getEmpl();
}

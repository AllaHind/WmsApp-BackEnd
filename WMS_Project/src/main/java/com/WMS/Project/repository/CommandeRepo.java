package com.WMS.Project.repository;

import com.WMS.Project.models.Attendu;
import com.WMS.Project.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepo extends JpaRepository<Commande,Long> {

    Commande findByCode(String code);
}

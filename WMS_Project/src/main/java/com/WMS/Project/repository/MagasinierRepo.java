package com.WMS.Project.repository;

import com.WMS.Project.models.Attendu;
import com.WMS.Project.models.Commande;
import com.WMS.Project.models.Magasinier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinierRepo extends JpaRepository<Magasinier,Long> {

    Magasinier findByCode(String code);
}

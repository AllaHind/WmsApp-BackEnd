package com.WMS.Project.repository;

import com.WMS.Project.models.Conditionnement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CdtRepo extends JpaRepository<Conditionnement,Long> {

    Conditionnement findByCode(String code);
}

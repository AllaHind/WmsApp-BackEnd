package com.WMS.Project.repository;

import com.WMS.Project.models.Attendu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttenduRepo extends JpaRepository<Attendu,Long> {

    Attendu findByCode(String code);
}

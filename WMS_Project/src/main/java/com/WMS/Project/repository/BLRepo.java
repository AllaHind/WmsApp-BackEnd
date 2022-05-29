package com.WMS.Project.repository;

import com.WMS.Project.models.BL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BLRepo extends JpaRepository<BL,Long> {

    BL findByBlNumero(String blNumero);

}

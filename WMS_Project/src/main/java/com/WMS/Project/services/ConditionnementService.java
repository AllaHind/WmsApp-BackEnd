package com.WMS.Project.services;

import com.WMS.Project.models.Conditionnement;
import com.WMS.Project.repository.CdtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConditionnementService {
    @Autowired
    private CdtRepo cdtRepo;

    public Conditionnement findByCode(String code) {
        return cdtRepo.findByCode(code);
    }

    public int save(Conditionnement cdt) {
        cdt.setCode(UUID.randomUUID().toString());
        if (findByCode(cdt.getCode()) != null) {
            return -1;
        } else {
            cdtRepo.save(cdt);
            return 1;
        }
    }
}

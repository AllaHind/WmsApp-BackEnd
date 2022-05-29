package com.WMS.Project.services;

import com.WMS.Project.models.Attendu;
import com.WMS.Project.models.BL;
import com.WMS.Project.models.Categorie;
import com.WMS.Project.models.OrderItem;
import com.WMS.Project.payload.response.MessageResponse;
import com.WMS.Project.repository.AttenduRepo;
import com.WMS.Project.repository.BLRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BLService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private BLRepo blRepo;
    @Autowired
    private AttenduRepo attenduRepo;

    public ResponseEntity<?>  save(BL bl) {
        if(findByBlNumero(bl.getBlNumero())!=null)
        {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Code existant"));
        }
        Attendu attendu=attenduRepo.findByCode(bl.getAttendu().getCode());
        bl.setAttendu(attendu);
        bl.getAttendu().setEtat("reçu");

         blRepo.save(bl);
        for(OrderItem orderItem:bl.getAttendu().getCommande().getOrderItems()) {
            articleService.updateArticle(orderItem.getArticle(),bl.getQttReçu());
        }



        return ResponseEntity.ok(new MessageResponse("Saved successfully"));
    }

    public List<BL> findAll() {
        return blRepo.findAll();
    }

    public BL findByBlNumero(String blNumero) {
        return blRepo.findByBlNumero(blNumero);
    }
@Transactional
    public void deleteById(Long aLong) {
        blRepo.deleteById(aLong);
    }
}


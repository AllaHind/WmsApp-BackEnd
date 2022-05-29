package com.WMS.Project.services;

import com.WMS.Project.models.Article;
import com.WMS.Project.models.Conditionnement;
import com.WMS.Project.models.Emplacement;
import com.WMS.Project.payload.response.MessageResponse;
import com.WMS.Project.repository.CdtRepo;
import com.WMS.Project.repository.EmplacementRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmplacementRep emplacementRep;
@Autowired
private CdtRepo cdtRepo;
    public Emplacement findByCode(String code) {
        return emplacementRep.findByCode(code);
    }


    public void setEmplacementRep(EmplacementRep emplacementRep) {
        this.emplacementRep = emplacementRep;
    }

    public ResponseEntity<?> save(Emplacement emp) {
        emp.setCode(getAlphaNumericString(6));
        emp.setCode(emp.getAlle() +"-"+ emp.getTravee() +"-"+ emp.getNiveau() +"-"+ emp.getAlveole());
        emp.setStatus("vide");
        if (findByCode(emp.getCode()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Code existant"));
        }
        if (emp.getAlle()==null || emp.getTravee()==null || emp.getNiveau()==null || emp.getAlveole()==null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Les champs (*) sont obligatoires"));
        } else {

            emplacementRep.save(emp);

            return ResponseEntity.ok(new MessageResponse("Emplacement registered successfully!"));

        }
    }
    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
    public  List<Emplacement> findAll() {
        return emplacementRep.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        emplacementRep.deleteById(id);
    }
}

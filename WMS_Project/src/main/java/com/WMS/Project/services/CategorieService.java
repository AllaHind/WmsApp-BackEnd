package com.WMS.Project.services;

import com.WMS.Project.models.Categorie;
import com.WMS.Project.payload.response.MessageResponse;
import com.WMS.Project.repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepo categorieRepo;

    public Categorie findByCode(String code) {
        return categorieRepo.findByCode(code);
    }

    public ResponseEntity<?> save(Categorie categorie) {

           categorie.setCode(getAlphaNumericString(6));
            if (findByCode(categorie.getCode()) != null) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Code existant"));
            }

            else categorieRepo.save(categorie);
            return ResponseEntity.ok(new MessageResponse("Category registered successfully!"));

    }

    public List<Categorie> findAll() {
        return categorieRepo.findAll();
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

    @Transactional
    public void deleteById(long id) {
        categorieRepo.deleteById(id);
    }
}

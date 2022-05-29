package com.WMS.Project.services;


import com.WMS.Project.models.Article;
import com.WMS.Project.models.Attendu;
import com.WMS.Project.models.Commande;
import com.WMS.Project.models.OrderItem;
import com.WMS.Project.payload.response.MessageResponse;
import com.WMS.Project.repository.ArticleRepository;
import com.WMS.Project.repository.AttenduRepo;
import com.WMS.Project.repository.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttenduService {

    @Autowired
    private AttenduRepo attenduRepo;
    @Autowired
    private CommandeRepo commandeRepo;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private ArticleRepository articleRepository;
@Autowired
private  OrderItemService orderItemService;
    public Attendu findByCode(String code) {
        return attenduRepo.findByCode(code);
    }

    public ResponseEntity<?> save(Attendu attendu) {
        attendu.setCode(getAlphaNumericString(6));
        attendu.setDateCreation(LocalDate.now());
        attendu.setEtat("Crée");
        attenduRepo.save(attendu);
        commandeService.save(attendu.getCommande(),attendu,attendu.getCommande().getOrderItems());
        return ResponseEntity.ok(new MessageResponse("Commande registered successfully!"));
    }

    static String getAlphaNumericString(int n) {

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
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


}

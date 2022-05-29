package com.WMS.Project.services;

import com.WMS.Project.models.Article;
import com.WMS.Project.models.Attendu;
import com.WMS.Project.models.Commande;
import com.WMS.Project.models.OrderItem;
import com.WMS.Project.payload.response.MessageResponse;
import com.WMS.Project.repository.ArticleRepository;
import com.WMS.Project.repository.CommandeRepo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepo commandeRepo;
    @Autowired
    private OrderItemService orderItemService;
@Autowired
private ArticleRepository articleRepository;
    public ResponseEntity<?> save(Commande commande) {
        commande.setCode(getAlphaNumericString(6));
        commande.setDateCreation(LocalDate.now());
        commande.setQttTotale(getTotalOrder(commande));
        commandeRepo.save(commande);
        orderItemService.save(commande, commande.getOrderItems());
        return ResponseEntity.ok(new MessageResponse("Commande registered successfully!"));
    }
    public int getTotalOrder(Commande commande) {
        int sum = 0;
        List<OrderItem> orderItems=commande.getOrderItems();
        for (OrderItem op : orderItems) {
            sum += op.getQtt();
        }
        return sum;
    }
    public List<Commande> findAll() {
        return commandeRepo.findAll();
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

    public Commande findByCode(String code) {
        return commandeRepo.findByCode(code);
    }
    public  int save(Commande commande,Attendu attendu,List<OrderItem> orderItems) {
        // TODO Auto-generated method stub
        for(OrderItem orderItem:orderItems)
        {
            orderItem.setCommande(commande);
            orderItemService.save(orderItem);
        }
        attendu.setCommande(commande);

        save(commande);
        return 1;
    }

}

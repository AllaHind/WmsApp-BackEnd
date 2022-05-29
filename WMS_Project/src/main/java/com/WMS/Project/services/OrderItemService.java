package com.WMS.Project.services;

import com.WMS.Project.models.Article;
import com.WMS.Project.models.Commande;
import com.WMS.Project.models.OrderItem;
import com.WMS.Project.repository.ArticleRepository;
import com.WMS.Project.repository.OrderItemRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;
@Autowired
private ArticleRepository articleRepository;
    public int  save(OrderItem orderItem) {
        orderItem.setCode(getAlphaNumericString(6));
        if (findByCode(orderItem.getCode()) != null) {
            return -1;
        } else {
            Article article = articleRepository.findByNom(orderItem.getArticle().getNom());
            orderItem.setArticle(article);
            orderItemRepository.save(orderItem);
            return 1;
        }
    }

    public OrderItem findByCode(String code) {
        return orderItemRepository.findByCode(code);
    }
    public  int save(Commande commande, List<OrderItem> orderItems) {
        // TODO Auto-generated method stub
        for (OrderItem d : orderItems) {
            d.setCommande(commande);
           save(d);

        }
        return 1;
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
}

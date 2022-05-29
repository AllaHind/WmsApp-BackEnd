package com.WMS.Project.services;

import com.WMS.Project.models.*;
import com.WMS.Project.payload.response.MessageResponse;
import com.WMS.Project.repository.ArticleRepository;
import com.WMS.Project.repository.CategorieRepo;
import com.WMS.Project.repository.CdtRepo;
import com.WMS.Project.repository.EmplacementRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;


@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategorieRepo categorieRepo;
    @Autowired
    private EmplacementRep emplacementRep;

    @Query("select COUNT(*) from Article ")
    public int GetNumberProduct() {
        return articleRepository.GetNumberProduct();
    }

    @Query("select count(*) from Article a  where a.approv>a.qtt")
    public int getAppro() {
        return articleRepository.getAppro();
    }

    public Article findByCode(String code) {
        return articleRepository.findByCode(code);
    }

    public Article findByCup(long cup) {
        return articleRepository.findByCup(cup);
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    public ResponseEntity<?> save(Article article) {
        article.setCode(getAlphaNumericString(6));
        if (findByCode(article.getCode()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Code existant"));
        } else if (findByCup(article.getCup()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("CUP existant"));
        } else if (article.getCode() == null || article.getCup() == 0 || article.getNom() == null || article.getDateExp() == null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Les champs (*) sont obligatoires"));
        } else {
            if(article.getCategorie().getNom().equals("eau de Javel"))
            {
                article.setEmplacement(getEmpl());
                if(getEmpl()!=null) {
                    getEmpl().setStatus("occupé");
                }
                else {
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Pas d'emplacement disponible!Pensez a créer un"));
                }
            }


            Categorie categorie=categorieRepo.findByNom(article.getCategorie().getNom());
            article.setCategorie(categorie);
            articleRepository.save(article);


            return ResponseEntity.ok(new MessageResponse("Article registered successfully!"));
        }
    }

    @Query("SELECT e FROM Emplacement e WHERE e.id = (SELECT  MAX(e.id) FROM  Emplacement e WHERE  e.status='vide' and e.niveau='00')")
    public Emplacement getEmpl() {
        return emplacementRep.getEmpl();
    }
    public List<Article> findAll () {
            return articleRepository.findAll();

        }
        @Transactional
        public void deleteById (Long id){
            articleRepository.deleteById(id);
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
public  void updateArticle(Article article,int quantity){

        int articleQuantity=article.getQtt();
       int nvQuantity=articleQuantity+quantity;
       article.setQtt(nvQuantity);

}

}
package com.WMS.Project.repository;

import com.WMS.Project.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByCode(String code);
    Article findByCup(long cup);
    Article findByNom(String nom);
@Query("select COUNT(*) from Article ")
    int GetNumberProduct();

@Query("select count(*) from Article a  where a.approv>a.qtt")
    int getAppro();
}

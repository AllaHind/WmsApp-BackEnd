package com.WMS.Project.repository;

import com.WMS.Project.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByCode(String code);
    Article findByCup(long cup);

}

package com.inventario.calzado.repo;

import com.inventario.calzado.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {

}

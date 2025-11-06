package com.inventario.calzado.api;

import com.inventario.calzado.model.Article;
import com.inventario.calzado.repo.ArticleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleApiController {

    private final ArticleRepository repo;

    public ArticleApiController(ArticleRepository repo) {
        this.repo = repo;
    }

    // GET /api/articles
    @GetMapping
    public List<Article> all() {
        return repo.findAll();
    }

    // GET /api/articles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Article> byId(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/articles
    @PostMapping
    public ResponseEntity<Article> create(@RequestBody Article a) {
        // En JPA, save()
        Article saved = repo.save(a);
        return ResponseEntity
                .created(URI.create("/api/articles/" + saved.getId()))
                .body(saved);
    }

    // PUT /api/articles/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article a) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }


        a.setId(id);
        Article updated = repo.save(a);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/articles/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

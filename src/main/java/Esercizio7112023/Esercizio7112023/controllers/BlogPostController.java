package Esercizio7112023.Esercizio7112023.controllers;

import Esercizio7112023.Esercizio7112023.entities.BlogPost;
import Esercizio7112023.Esercizio7112023.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    BlogPostService blogPostService;
    @GetMapping()
    public List<BlogPost> getAllBlogPosts(){
            return blogPostService.getAllBlogPosts();
    }
    @GetMapping("/{id}")
    public BlogPost getSingleBlogPost(@PathVariable int id) throws Exception {
        return blogPostService.getSingleBlogPost(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public int saveNewPost(@RequestBody BlogPost p) throws IOException {
        return blogPostService.saveNewPost(p);
    }

    @PutMapping("/{id}")
    public BlogPost modifyBlogPost(@RequestBody BlogPost p,@PathVariable int id) throws IOException {
        return blogPostService.modifyBlogPost(p,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSingleBlogPost(@PathVariable int id) throws IOException {
        blogPostService.deleteSingleBlogPost(id);
    }
}

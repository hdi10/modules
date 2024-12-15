package com.zelkulon.zelkulonapi.blogs.port.controller;



import com.zelkulon.zelkulonapi.Authorization;
import com.zelkulon.zelkulonapi.blogs.core.domain.model.Blog;

import com.zelkulon.zelkulonapi.blogs.core.domain.service.impl.BlogService;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.createBlog(blog));
    }
}


/*
    //////////////////////////////////////////////////////////////////////////////
    //////////      GET Methods Start////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getBlogById(
            @RequestHeader(value = "Authorization") String authHeader,
            @PathVariable(value = "id") Long id) {
        try {
            authUser(authHeader).block();
            return service.getBlogById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }*/

  /*  @RequestMapping(method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getAllBlogs(
            @RequestHeader(value = "Authorization") String authHeader) {
        try {

            authUser(authHeader).block();
            return service.getAllBlogs();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }*/

    //////////////////////////////////////////////////////////////////////////////
    //////////      POST Methods Start  /////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

/*    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<?>
    addBlog(
            @RequestHeader("Authorization") String authToken, @RequestBody Blog blogToAdd) {
        try {
            authUser(authToken).block();
            return service.postBlog(blogToAdd);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }*/

    //////////////////////////////////////////////////////////////////////////////
    //////////      POST Methods END    /////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////
    //////////      PUT Methods Start  /////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

/*    @PutMapping(value = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<?>
    updateBlog(
            @RequestHeader("Authorization") String authToken,
            @PathVariable(value = "id") Long id,
            @RequestBody Blog blogToPut) {
        try {
            String currentUser = authUser(authToken).block();

            logger.info("id: " + id);
            logger.info("blogToPut: " + blogToPut);
            logger.info("Current User: " + currentUser);

            ResponseEntity<?> myResponse = service.updateBlog(id, blogToPut);

            logger.info("myResponse: " + myResponse);

            return myResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }*/

    //////////////////////////////////////////////////////////////////////////////
    //////////      PUT Methods END  /////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////
    //////////      DELETE Methods Start  /////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

/*    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBlog(
            @RequestHeader("Authorization") String authToken,
            @PathVariable(value = "id") Long id) {
        try {
            authUser(authToken).block();
            return service.deleteBlog(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }*/

    //////////////////////////////////////////////////////////////////////////////
    //////////      DELETE Methods END  /////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////


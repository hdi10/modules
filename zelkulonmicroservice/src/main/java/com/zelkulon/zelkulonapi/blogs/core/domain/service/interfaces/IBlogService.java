package com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces;

import com.zelkulon.zelkulonapi.blogs.core.domain.model.Blog;
import org.springframework.http.ResponseEntity;

public interface IBlogService {

    ResponseEntity<?> getBlogById(Long id);

    ResponseEntity<?> getAllBlogs();

    ResponseEntity<?> postBlog(Blog blogToAdd);

    ResponseEntity<?> updateBlog(Long id, Blog BlogToPut);

    ResponseEntity<?> deleteBlog(Long id);

}

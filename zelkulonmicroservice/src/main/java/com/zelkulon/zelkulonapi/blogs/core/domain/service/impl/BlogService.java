package com.zelkulon.zelkulonapi.blogs.core.domain.service.impl;
//
 //* Dastekin created on 12.07.2023 the BlogService-Class inside the package - de.dastekin.zelkulon.blogs.core.domain.service.impl
 //*/

/*

package com.zelkulon.zelkulonapi.blogs.core.domain.service.impl;

import com.zelkulon.zelkulonapi.blogs.core.domain.model.Blog;
import com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces.BlogRepository;
import com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces.IBlogService;
import com.zelkulon.zelkulonapi.blogs.port.exception.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;
import java.util.Objects;
import java.util.logging.Logger;

@Service
public class BlogService {
    Logger logger = Logger.getLogger(BlogService.class.getName());
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    @GetMapping
    public ResponseEntity<?> getBlogById(Long id) {
        try {
            Blog blog = blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
            return new ResponseEntity<>(blog, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping


    */
/*@Override
    public ResponseEntity<?> getAllBlogs() {
        return new ResponseEntity<>(blogRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> postBlog(Blog blogToAdd) {
        if (blogToAdd.getTitle() != null && !blogToAdd.getTitle().isEmpty()) {
            Blog newBlog = blogRepository.save(blogToAdd);
            HttpHeaders header = new HttpHeaders();
            header.setLocation(URI.create("/blogs/" + newBlog.getId()));
            return new ResponseEntity<>(blogToAdd, header, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> updateBlog(Long id, Blog blogToPut) {

        Long blogId = blogToPut.getId().longValue();
        logger.info("Submitted ID " + id + " with blogToPut.getId() " + blogToPut.getId());
        logger.info("The blogToPut is " + blogToPut);

        Blog blogToUpdate = blogRepository.selectBlogById(id);
        logger.info("id " + id + " with blogToUpdate.getId() " + blogToUpdate.getId());
        logger.info("blogToUpdate " + blogToUpdate);

        if (blogId.equals(id)) {

            if (!Objects.equals(blogToUpdate.getTitle(), blogToPut.getTitle()) && blogToPut.getTitle() != null) {
                blogToUpdate.setTitle(blogToPut.getTitle());
                logger.info("blogToUpdate.getTitle() " + blogToUpdate.getTitle());
                logger.info("blogToPut.getTitle() " + blogToPut.getTitle());
            }
            if (!Objects.equals(blogToUpdate.getLocation(), blogToPut.getLocation()) && blogToPut.getLocation() != null) {
                blogToUpdate.setLocation(blogToPut.getLocation());
            }
            if (!Objects.equals(blogToUpdate.getTimestamp(), blogToPut.getTimestamp()) && blogToPut.getTimestamp() != null) {
                blogToUpdate.setTimestamp(blogToPut.getTimestamp());
            }

            blogRepository.save(blogToUpdate);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> deleteBlog(Long id) {
        var blog = blogRepository.findById(id);
        if (blog.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        try {
            blogRepository.delete(blog.get());
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.LOCKED);
        }

        return ResponseEntity.noContent().build();
    }*//*

}
*/

import com.zelkulon.zelkulonapi.blogs.core.domain.model.Blog;
import com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces.BlogRepository;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BlogService {
    Logger logger = Logger.getLogger(BlogService.class.getName());

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public ResponseEntity<?> updateBlog(Long id, Blog blogToPUT){

        Long blogId = blogToPUT.getId().longValue();
        logger.info("übergebene ID " + id + "mit songToPut.getId() " + blogToPUT.getId());
        logger.info("der songtoPut lautet " + blogToPUT);

        Blog blogToUpdate = blogRepository.findBlogById(id);
        logger.info("id " + id + "mit blogToUpdate.getId() " + blogToUpdate.getId());
        logger.info("blogToUpdate " + blogToUpdate);

        if (blogId.equals(id)) {

            if (!Objects.equals(blogToUpdate.getTitle(), blogToPUT.getTitle()) && blogToPUT.getTitle()!=null) {
                blogToUpdate.setTitle(blogToPUT.getTitle());
                logger.info("blogToUpdate.getTitle() " + blogToUpdate.getTitle());
                logger.info("songToPut.getTitle() " + blogToPUT.getTitle());

            }
            if (!Objects.equals(blogToUpdate.getArtist(), blogToPUT.getArtist()) && blogToPUT.getArtist()!=null) {
                blogToUpdate.setArtist(blogToPUT.getArtist());
            }
            if (!Objects.equals(blogToUpdate.getLocation(), blogToPUT.getLocation()) && blogToPUT.getLocation()!=null) {
                blogToUpdate.setLocation(blogToPUT.getLocation());
            }
            if (!Objects.equals(blogToUpdate.getTimestamp(), blogToPUT.getTimestamp()) && blogToPUT.getTimestamp()!=null) {
                blogToUpdate.setTimestamp(blogToPUT.getTimestamp());
            }

            blogRepository.save(blogToUpdate);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}

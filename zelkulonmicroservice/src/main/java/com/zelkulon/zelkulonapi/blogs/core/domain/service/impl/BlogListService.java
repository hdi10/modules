/*
package com.zelkulon.zelkulonapi.blogs.core.domain.service.impl;

import com.zelkulon.zelkulonapi.blogs.core.domain.model.BlogList;
import com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces.BlogListRepository;
import com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces.BlogRepository;
import com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces.IBlogListService;
import com.zelkulon.zelkulonapi.blogs.port.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BlogListService implements IBlogListService {
    private final BlogListRepository blogListRepository;
    private final BlogRepository blogRepository;

    public BlogListService(BlogListRepository blogListRepository, BlogRepository blogRepository) {
        this.blogListRepository = blogListRepository;
        this.blogRepository = blogRepository;
    }

*/
/*    @Override
    public ResponseEntity<?> getAllBloglistsvomOwnerObPrivateOderNicht(String userId) {
        return ResponseEntity.ok(blogListRepository.findAllByOwnerId(userId));
    }

    @Override
    public ResponseEntity<?> getAllBlogsVonJemandAnderem(String ownerId) {
        return ResponseEntity.ok(blogListRepository.findAllByOwnerIdAndIsPrivateFalse(ownerId));
    }

    @Override
    public boolean gibtEsDenUser(String ownerId) {
        return blogListRepository.existsByOwnerId(ownerId);
    }

    @Override
    public boolean gibtEsDieSonglisteMitDerID(Long blogListId) {
        return blogListRepository.existsById(blogListId);
    }

    @Override
    public ResponseEntity<BlogList> gibMirDieBlogListeMitDerId(Long blogListId) {
        return blogListRepository.findById(blogListId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    public String gibMirNameUserMitDieserBlogId(Long blogListId) {
        return blogListRepository.findById(blogListId)
                .map(BlogList::getOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog list not found with ID: " + blogListId));
    }

    @Override
    public boolean istDieseListePublic(Long blogListId) {
        return blogListRepository.findById(blogListId)
                .map(blogList -> !blogList.getPrivate())
                .orElse(false);
    }*//*


    @Override
    public ResponseEntity<BlogList> addBlogList(String userId, BlogList blogList2Add) {
        blogList2Add.setOwnerId(userId);
        BlogList savedBlogList = blogListRepository.save(blogList2Add);
        return new ResponseEntity<>(savedBlogList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateBlogListe(String userId, Long id, BlogList blogList2Update) {
        return blogListRepository.findById(id).map(existingList -> {
            if (!existingList.getOwnerId().equals(userId)) {
                return new ResponseEntity<>("You are not authorized to update this blog list", HttpStatus.FORBIDDEN);
            }
            existingList.setName(blogList2Update.getName());
            existingList.setPrivate(blogList2Update.getPrivate());
            existingList.setBlogList(blogList2Update.getBlogList());
            blogListRepository.save(existingList);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }).orElseGet(() -> new ResponseEntity<>("Blog list not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteThisBlogList(Long blogListId) {
        if (!blogListRepository.existsById(blogListId)) {
            throw new ResourceNotFoundException("Blog list not found with ID: " + blogListId);
        }
        blogListRepository.deleteById(blogListId);
    }
}
*/

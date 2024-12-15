/*
package com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces;

import com.zelkulon.zelkulonapi.blogs.core.domain.model.Blog;
import com.zelkulon.zelkulonapi.blogs.core.domain.model.BlogList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BlogListRepository extends CrudRepository<BlogList, Long> {

    Iterable<BlogList> findAllByOwnerId(String userId);

    Iterable<BlogList> findAllByOwnerIdAndIsPrivateFalse(String userId);

    boolean existsByOwnerId(String userId);

    Optional<BlogList> findById(Long id);

  */
/*  @Query("SELECT b FROM BlogList b WHERE b.ownerId = :ownerId")
    Iterable<BlogList> getAllSongListOfSpecificOwnerPrivateAndPublic(String ownerId);

    @Query("SELECT b FROM BlogList b WHERE b.ownerId = :ownerId AND b.isPrivate = false")
    Iterable<BlogList> getAllSongListVonAnderemUserDiePublicSind(String ownerId);

    @Query("SELECT b FROM Blog b WHERE b.id = :id")
    Blog selectBlogById(@Param("id") Long id);

    @Query("SELECT COUNT(b) > 0 FROM BlogList b WHERE b.ownerId = :ownerId")
    boolean gibtEsDenUserUeberhaupt(String ownerId);

    @Query("SELECT b FROM BlogList b WHERE b.id = :id")
    Optional<BlogList> gibMirDieSongListMitDerId(Long id);

    @Query("SELECT COUNT(b) > 0 FROM BlogList b WHERE b.id = :id")
    boolean gibtEsUeberhauptDieSonglisteMitDerId(Long id);

    @Query("SELECT b.ownerId FROM BlogList b WHERE b.id = :id")
    String gibMirBitteDenNamenDesUsersMitDerSongListId(Long id);

    @Query("SELECT COUNT(b) > 0 FROM BlogList b WHERE b.id = :id AND b.isPrivate = false")
    boolean istVerlangteSongListePublic(Long id);*//*

}
*/

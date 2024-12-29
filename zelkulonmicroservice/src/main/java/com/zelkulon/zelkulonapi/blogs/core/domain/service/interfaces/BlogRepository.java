package com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces;
/**
 * Dastekin created for zelkulon on 13.12.2024 the BlogsRepository-Class inside the package - com.zelkulon.zelkulonapi.core.domain.service.interfaces;
 *//*


package com.zelkulon.zelkulonapi.blogs.core.domain.service.interfaces;



import com.zelkulon.zelkulonapi.blogs.core.domain.model.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {
*/
/*
    @Query(value = "SELECT * FROM blog WHERE blog_id = ?1", nativeQuery = true)
    Blog selectSongById(Long id);

    @Query(value = "SELECT * FROM blog", nativeQuery = true)
    List<Blog> getAllBlogs();
*//*


    @Query(value = "SELECT Blog WHERE Blog.Id=?1")
    Blog getBlogById(Long id);


    */
/*@Query(value = "SELECT * FROM songs ", nativeQuery = true)
    List<Song> selectAllSongs();

    @Query(value = "UPDATE songs SET title = ?2 WHERE id = ?1 RETURNING *", nativeQuery = true)
    String updateSongTitle(String id, String title);

    @Query(value = "UPDATE songs SET artist=?2 WHERE id = ?1", nativeQuery = true)
    void updateSongArtist(String id, String artist);

    @Query(value = "UPDATE songs SET label=?2 WHERE id = ?1", nativeQuery = true)
    void updateSongLabel(String id, String label);

    @Query(value = "UPDATE songs SET released=?2 WHERE id = ?1", nativeQuery = true)
    void updateSongReleased(String id, String released);

    @Query(value= "DELETE *  WHERE id=?1", nativeQuery = true)
    void deleteSongsBy(Long id);*//*

}*/


import com.zelkulon.zelkulonapi.blogs.core.domain.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    // Suche Blogs nach Titel
    List<Blog> findByTitle(String title);

    // Suche Blogs nach Artist
    List<Blog> findByArtist(String artist);

    // Suche Blogs nach Location
    List<Blog> findByLocation(String location);

    // Suche Blogs nach Titel und Artist
    List<Blog> findByTitleAndArtist(String title, String artist);

    // Suche Blogs nach Zeitstempel nach einem bestimmten Datum
    List<Blog> findByTimestampAfter(LocalDateTime timestamp);

    Blog findBlogById(Long id);
}

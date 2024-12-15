/** Dastekin created for zelkulon
 * Model class for Blog
 */

package com.zelkulon.zelkulonapi.blogs.core.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long Id;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    String artist;

    @Column(name = "location")
    String location;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Blog(){

    }

    public Blog(Long id, String title, String artist, String location, LocalDateTime timestamp) {
        Id = id;
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.timestamp = timestamp;
    }

    public Blog(String title, String artist, String location, LocalDateTime timestamp) {
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", location='" + location + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }


}


/**
 * dastekin for zelkulon 13.12.2024 - model blog list
 */
package com.zelkulon.zelkulonapi.blogs.core.domain.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "blog_list")
public class BlogList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_list_id")
    private Integer id;

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name="name")
    private String name;

    @Column(name="is_private")
    private Boolean isPrivate;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) //TODO vielleicht den fetch type ändern auf lazy um die performance zu verbessern
    @JoinTable(
            name = "contains_blog",
            joinColumns = {@JoinColumn(name = "blog_list_id" , referencedColumnName = "blog_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "blog_id", referencedColumnName = "blog_id")})
    //TODO hier orderby?
    //@OrderBy(value = "id")
    private Set<Blog> blogList = new HashSet<>();

    public BlogList() {

    }

    public BlogList(Integer id, String ownerId, String name, Boolean isPrivate, Set<Blog> songList) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.isPrivate = isPrivate;
        this.blogList = blogList;
    }

    public BlogList(String ownerId, String name, Boolean isPrivate, Set<Blog> blogList) {
        this.ownerId = ownerId;
        this.name = name;
        this.isPrivate = isPrivate;
        this.blogList = blogList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Set<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(Set<Blog> blogList) {
        this.blogList = blogList;
    }

    @Override
    public String toString() {
        return "BlogList{" +
                "id=" + id +
                ", ownerId='" + ownerId + '\'' +
                ", name='" + name + '\'' +
                ", isPrivate=" + isPrivate +
                ", blogList=" + blogList +
                '}';
    }
}

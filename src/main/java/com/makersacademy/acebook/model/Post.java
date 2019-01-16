package com.makersacademy.acebook.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    public Post() {}

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Long getId(){
        return id;
    }
}

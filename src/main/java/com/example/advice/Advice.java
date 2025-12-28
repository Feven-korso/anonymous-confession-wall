package com.example.advice;

import java.time.LocalDateTime;

public class Advice {
    private int id;
    private String content;
    private int likes;
    private LocalDateTime createdAt;

    public Advice() {}

    public Advice(String content) {
        this.content = content;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

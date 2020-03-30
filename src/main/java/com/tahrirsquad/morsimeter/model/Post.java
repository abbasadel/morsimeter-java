package com.tahrirsquad.morsimeter.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "title_en")
    private String titleEn;


    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "content_en", columnDefinition = "TEXT")
    private String contentEn;

    private boolean published;

    @Column(name = "post_date")
    private LocalDate postDate;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private String sourceName;

    private String sourceLink;

    private String location;

}
package com.tahrirsquad.morsimeter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Promise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String title;

    @Enumerated(EnumType.STRING)
    PromiseStatus status;

    LocalDate completed_at;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    Category category;

    @OneToMany
    @JoinColumn(name = "promise_id")
    List<Post> posts;

}

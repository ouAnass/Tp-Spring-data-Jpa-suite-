package com.example.firstapp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,length = 25,nullable = false)
    private String title;
    private String description;
    private int timing;
    @OneToOne(mappedBy = "course")
    private Professor professor;
    @OneToMany
    private Collection<Session> sessions;

}

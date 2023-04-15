package com.example.firstapp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Professor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30,nullable = false)
    private String fullName;

    @Temporal(TemporalType.DATE) @CreationTimestamp
    private Date assignementDate;
    @OneToOne
    private Course course;
}

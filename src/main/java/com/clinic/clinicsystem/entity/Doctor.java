package com.clinic.clinicsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialization;

    private String phone;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    private String address;

    private Integer experience;

    private boolean available = true;

    @Column(length = 500)
    private String description;
}

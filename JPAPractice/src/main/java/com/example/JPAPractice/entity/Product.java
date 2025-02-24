package com.example.JPAPractice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="student_seq"
    )
    private Long productId;
    private String name;
    private String description;
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}

package org.example.cctv_test2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cctv_images")
@Getter
@Setter
public class CctvImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cctvNum;
    @Lob
    private String imageData;
}

package com.github.aksel.appSchool.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CARS")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PLATES")
    private String plates;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PROD_YEAR")
    private Integer prodYear;

    @Column(name = "MILEAGE")
    private Integer mileage;

    @Column(name = "LAST_MAINTENANCE_MILEAGE")
    private Integer lastMaintenanceMileage;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "TRAINER_ID", referencedColumnName = "id")
    private TrainerEntity trainer;
}

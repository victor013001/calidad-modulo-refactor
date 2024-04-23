package com.udea.sitas.dao.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "luggage")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Luggage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String type;

    @Column
    private Double extraCharge;

    @Column
    private Integer quantity;

    @Column
    private Double width;

    @Column
    private Double height;

    @Column
    private Double length;

    @Column
    private Double weight;

    @Column
    private String description;

    @Column
    private Long userId;

    @Column
    private Long flightId;

    @Column
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placement_area_id")
    PlacementArea placementArea;

}

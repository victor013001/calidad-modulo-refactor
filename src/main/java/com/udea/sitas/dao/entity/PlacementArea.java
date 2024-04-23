package com.udea.sitas.dao.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "placement_area")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PlacementArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
}

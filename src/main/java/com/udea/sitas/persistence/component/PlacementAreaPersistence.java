package com.udea.sitas.persistence.component;

import com.udea.sitas.persistence.dto.PlacementAreaDto;

import java.util.List;

public interface PlacementAreaPersistence {
    List<PlacementAreaDto> findAll();
    PlacementAreaDto findById(Long id);
    boolean placementAreaExist(Long id);
}

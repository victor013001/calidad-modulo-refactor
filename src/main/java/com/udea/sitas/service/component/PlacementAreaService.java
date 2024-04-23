package com.udea.sitas.service.component;

import com.udea.sitas.persistence.dto.PlacementAreaDto;

import java.util.List;

public interface PlacementAreaService {

    List<PlacementAreaDto> findAll();
    PlacementAreaDto findById(Long id);

    void placementAreaExist(Long id);
}

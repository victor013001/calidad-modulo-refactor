package com.udea.sitas.persistence.component;

import com.udea.sitas.dao.repository.PlacementAreaRepository;
import com.udea.sitas.persistence.dto.PlacementAreaDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@RequiredArgsConstructor
public class PlacementAreaPersistenceImpl implements PlacementAreaPersistence{

    private final PlacementAreaRepository placementAreaRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PlacementAreaDto> findAll() {
        return placementAreaRepository.findAll().stream()
                .map(placementArea -> modelMapper.map(placementArea, PlacementAreaDto.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PlacementAreaDto findById(Long id) {
        return placementAreaRepository.findById(id)
                .map(placementArea -> modelMapper.map(placementArea, PlacementAreaDto.class))
                .orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean placementAreaExist(Long id) {
        return placementAreaRepository.existsById(id);
    }
}

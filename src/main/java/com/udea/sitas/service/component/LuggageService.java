package com.udea.sitas.service.component;

import com.udea.sitas.persistence.dto.LuggageDto;

import java.util.List;

public interface LuggageService {

    LuggageDto create(LuggageDto luggageDto);
    List<LuggageDto> findAll();
    LuggageDto findById(Long id);
    void delete(Long id);
    LuggageDto update(LuggageDto luggageDto, Long id);
    List<LuggageDto> findByPlacementAreaId(Long id);
}

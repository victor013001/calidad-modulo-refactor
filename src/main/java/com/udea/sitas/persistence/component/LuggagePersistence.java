package com.udea.sitas.persistence.component;

import com.udea.sitas.persistence.dto.LuggageDto;

import java.util.List;

public interface LuggagePersistence {

    LuggageDto save(LuggageDto luggageToSave);
    List<LuggageDto> findAll();
    LuggageDto findById(Long id);
    void delete(Long id);

    boolean luggageExist(Long id);
    List<LuggageDto> findAllByPlacementAreaId(Long id);
    boolean userHasLuggage(Long userId);
}

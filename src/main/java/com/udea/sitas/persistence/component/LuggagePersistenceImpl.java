package com.udea.sitas.persistence.component;

import com.udea.sitas.dao.entity.Luggage;
import com.udea.sitas.dao.repository.LuggageRepository;
import com.udea.sitas.dao.repository.PlacementAreaRepository;
import com.udea.sitas.persistence.dto.LuggageDto;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LuggagePersistenceImpl implements LuggagePersistence{

    private final LuggageRepository luggageRepository;
    private final PlacementAreaRepository placementAreaRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public LuggageDto save(LuggageDto luggageToSave) {
        Luggage luggage = modelMapper.map(luggageToSave, Luggage.class);
        return modelMapper.map(luggageRepository.save(luggage), LuggageDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LuggageDto> findAll() {
        return luggageRepository.findAll().stream()
                .map(luggage -> modelMapper.map(luggage, LuggageDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public LuggageDto findById(Long id) {
        return luggageRepository.findById(id)
                .map(luggage -> modelMapper.map(luggage, LuggageDto.class))
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        luggageRepository.delete(
                luggageRepository.findById(id)
                        .orElseThrow()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean luggageExist(Long id) {
        return luggageRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LuggageDto> findAllByPlacementAreaId(Long id) {
        return luggageRepository.findByPlacementArea(
                placementAreaRepository.findById(id)
                        .orElseThrow())
                .stream()
                .map(luggage -> modelMapper.map(luggage, LuggageDto.class))
                .collect(Collectors.toList());
    }
}

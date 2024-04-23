package com.udea.sitas.dao.repository;

import com.udea.sitas.dao.entity.Luggage;
import com.udea.sitas.dao.entity.PlacementArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LuggageRepository extends JpaRepository<Luggage, Long> {

    List<Luggage> findByPlacementArea(PlacementArea placementArea);

}



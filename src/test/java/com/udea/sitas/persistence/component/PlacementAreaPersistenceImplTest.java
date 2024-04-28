package com.udea.sitas.persistence.component;

import com.udea.sitas.dao.entity.PlacementArea;
import com.udea.sitas.dao.repository.PlacementAreaRepository;
import com.udea.sitas.persistence.dto.PlacementAreaDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PlacementAreaPersistenceImplTest {

    @InjectMocks
    private PlacementAreaPersistenceImpl placementAreaPersistence;

    @Mock
    private PlacementAreaRepository placementAreaRepository;

    @Spy
    private ModelMapper modelMapper;

    PlacementArea placementAreaTest1 = PlacementArea.builder()
            .id(1L)
            .name("Area test 1")
            .build();

    PlacementArea placementAreaTest2 = PlacementArea.builder()
            .id(2L)
            .name("Area test 2")
            .build();

    PlacementArea placementAreaTest3 = PlacementArea.builder()
            .id(3L)
            .name("Area test 3")
            .build();

    List<PlacementArea> placementAreaList = List.of(placementAreaTest1,
            placementAreaTest2,
            placementAreaTest3);

    @Test
    void WhenGetAll_ShouldReturnPlacementAreaList() {
        Mockito.when(placementAreaRepository.findAll())
                .thenReturn(placementAreaList);

        final List<PlacementAreaDto> placementAreaDtoListResponse = placementAreaPersistence.findAll();

        Mockito.verify(placementAreaRepository)
                .findAll();

        Assertions.assertThat(placementAreaDtoListResponse)
                .extracting(PlacementAreaDto::getId)
                .contains(1L, 2L, 3L);
    }

    @Test
    void GivenPlacementAreaId_WhenFindById_ShouldReturnPlacementAreaWithId() {
        Mockito.when(placementAreaRepository.findById(1L))
                .thenReturn(Optional.of(placementAreaTest1));

        final PlacementAreaDto placementAreaDtoResponse = placementAreaPersistence.findById(1L);

        Mockito.verify(placementAreaRepository)
                .findById(1L);

        Assertions.assertThat(placementAreaDtoResponse)
                .hasFieldOrPropertyWithValue("id", 1L);
    }

    @Test
    void GivenPlacementAreaId_WhenCheckIfExist_ShouldReturnTrue() {
        Mockito.when(placementAreaRepository.existsById(1L))
                .thenReturn(true);

        final boolean placementAreaExist = placementAreaPersistence.placementAreaExist(1L);

        Mockito.verify(placementAreaRepository)
                .existsById(1L);

        Assertions.assertThat(placementAreaExist)
                .isTrue();
    }
}

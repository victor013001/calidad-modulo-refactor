package com.udea.sitas.service.component;

import com.udea.sitas.persistence.component.PlacementAreaPersistence;
import com.udea.sitas.persistence.dto.PlacementAreaDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PlacementAreaServiceImplTest {

    @InjectMocks
    private PlacementAreaServiceImpl placementAreaService;

    @Mock
    private PlacementAreaPersistence placementAreaPersistence;

    PlacementAreaDto placementAreaTest1 = PlacementAreaDto.builder()
            .id(1L)
            .name("Area test 1")
            .build();

    PlacementAreaDto placementAreaTest2 = PlacementAreaDto.builder()
            .id(2L)
            .name("Area test 2")
            .build();

    PlacementAreaDto placementAreaTest3 = PlacementAreaDto.builder()
            .id(3L)
            .name("Area test 3")
            .build();

    List<PlacementAreaDto> placementAreaDtoList = List.of(placementAreaTest1,
            placementAreaTest2,
            placementAreaTest3);

    @Test
    void WhenGetAll_ShouldReturnPlacementAreaList() {
        Mockito.when(placementAreaPersistence.findAll())
                .thenReturn(placementAreaDtoList);

        final List<PlacementAreaDto> placementAreaDtoListResponse = placementAreaService.findAll();

        Mockito.verify(placementAreaPersistence)
                .findAll();

        Assertions.assertThat(placementAreaDtoListResponse)
                .extracting(PlacementAreaDto::getId)
                .contains(1L, 2L, 3L);
    }

    @Test
    void GivenPlacementAreaId_WhenFindById_ShouldReturnPlacementAreaWithId() {
        Mockito.when(placementAreaPersistence.findById(1L))
                .thenReturn(placementAreaTest1);

        final PlacementAreaDto placementAreaDtoResponse = placementAreaService.findById(1L);

        Mockito.verify(placementAreaPersistence)
                .findById(1L);

        Assertions.assertThat(placementAreaDtoResponse)
                .hasFieldOrPropertyWithValue("id", 1L);
    }

    @Test
    void GivenNonExistPlacementAreaId_WhenCheckIfExist_ShouldThrowException() {
        Mockito.when(placementAreaPersistence.placementAreaExist(1L))
                .thenReturn(false);

        Exception exception = assertThrows(
                NoSuchElementException.class,
                () -> placementAreaService.placementAreaExist(1L));

        Assertions.assertThat(exception.getMessage())
                .contains("Placement area does not exist");
    }

}

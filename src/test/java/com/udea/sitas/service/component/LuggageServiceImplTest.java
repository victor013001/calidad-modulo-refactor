package com.udea.sitas.service.component;

import com.udea.sitas.persistence.component.LuggagePersistence;
import com.udea.sitas.persistence.dto.LuggageDto;
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
class LuggageServiceImplTest {

    @InjectMocks
    private LuggageServiceImpl luggageService;

    @Mock
    private LuggagePersistence luggagePersistence;
    @Mock
    private PlacementAreaService placementAreaService;

    PlacementAreaDto placementAreaTest = PlacementAreaDto.builder()
            .id(1L)
            .name("Area test")
            .build();

    LuggageDto luggageDtoToSave = LuggageDto.builder()
            .bookingId(1L)
            .description("Test Luggage")
            .extraCharge(10.0)
            .type("Test")
            .flightId(1L)
            .height(10.0)
            .width(10.0)
            .weight(10.0)
            .length(10.0)
            .userId(1L)
            .quantity(1)
            .placementArea(placementAreaTest)
            .build();

    LuggageDto luggageDto1 = LuggageDto.builder()
            .id(1L)
            .bookingId(1L)
            .description("Test Luggage 1")
            .extraCharge(10.0)
            .type("Test")
            .flightId(1L)
            .height(10.0)
            .width(10.0)
            .weight(10.0)
            .length(10.0)
            .userId(1L)
            .quantity(1)
            .placementArea(placementAreaTest)
            .build();

    LuggageDto luggageDto2 = LuggageDto.builder()
            .id(2L)
            .bookingId(1L)
            .description("Test Luggage 2")
            .extraCharge(10.0)
            .type("Test")
            .flightId(1L)
            .height(10.0)
            .width(10.0)
            .weight(10.0)
            .length(10.0)
            .userId(1L)
            .quantity(1)
            .placementArea(placementAreaTest)
            .build();

    LuggageDto luggageDtoToUpdate = LuggageDto.builder()
            .bookingId(1L)
            .description("Updated Luggage")
            .extraCharge(10.0)
            .type("Test")
            .flightId(1L)
            .height(10.0)
            .width(10.0)
            .weight(10.0)
            .length(10.0)
            .userId(1L)
            .quantity(1)
            .placementArea(placementAreaTest)
            .build();

    List<LuggageDto> luggageDtoList = List.of(luggageDto1,luggageDto2);

    @Test
    void GivenLuggageWithPlacementArea_WhenCreate_ShouldReturnWithId() {

        LuggageDto luggageDtoSaved = luggageDtoToSave;
        luggageDtoSaved.setId(1L);

        Mockito.when(luggagePersistence.save(luggageDtoToSave))
                .thenReturn(luggageDtoSaved);

        final LuggageDto luggageDtoResponse = luggageService.create(luggageDtoToSave);

        Mockito.verify(placementAreaService)
                .placementAreaExist(1L);

        Mockito.verify(luggagePersistence)
                .save(luggageDtoToSave);

        Assertions.assertThat(luggageDtoResponse)
                .hasFieldOrPropertyWithValue("id", 1L);
    }

    @Test
    void WhenGetAll_ShouldReturnLuggageList() {
        Mockito.when(luggagePersistence.findAll())
                .thenReturn(luggageDtoList);

        final List<LuggageDto> luggageListResponse = luggageService.findAll();

        Mockito.verify(luggagePersistence)
                .findAll();

        Assertions.assertThat(luggageListResponse)
                .extracting(LuggageDto::getId)
                .contains(1L, 2L);
    }

    @Test
    void GivenLuggageId_WhenFindById_ShouldReturnLuggageWithId() {
        Mockito.when(luggagePersistence.findById(1L))
                .thenReturn(luggageDto1);

        final LuggageDto luggageDtoResponse = luggageService.findById(1L);

        Mockito.verify(luggagePersistence)
                .findById(1L);

        Assertions.assertThat(luggageDtoResponse)
                .hasFieldOrPropertyWithValue("id", 1L);
    }

    @Test
    void GivenLuggageId_WhenDelete() {
        Mockito.when(luggagePersistence.luggageExist(1L))
                .thenReturn(true);

        luggageService.delete(1L);

        Mockito.verify(luggagePersistence)
                .luggageExist(1L);
        Mockito.verify(luggagePersistence)
                .delete(1L);
    }

    @Test
    void GivenLuggageAndId_WhenUpdate_ShouldChangeDescription() {

        LuggageDto luggageDtoUpdated = luggageDtoToUpdate;
        luggageDtoUpdated.setId(1L);

        Mockito.when(luggagePersistence.luggageExist(1L))
                .thenReturn(true);

        Mockito.when(luggagePersistence.save(luggageDtoToUpdate))
                .thenReturn(luggageDtoUpdated);

        final LuggageDto luggageDtoResponse = luggageService.update(luggageDtoToUpdate, 1L);

        Mockito.verify(luggagePersistence)
                        .luggageExist(1L);

        Mockito.verify(placementAreaService)
                .placementAreaExist(1L);

        Assertions.assertThat(luggageDtoResponse)
                .hasFieldOrPropertyWithValue("description", "Updated Luggage");
    }

    @Test
    void GivenPlacementAreaId_WhenFindByPlacementAreaId_ShouldReturnAllLuggageWithPlacementAreaId() {
        Mockito.when(luggagePersistence.findAllByPlacementAreaId(1L))
                .thenReturn(luggageDtoList);

        final List<LuggageDto> luggageListResponse = luggageService.findByPlacementAreaId(1L);

        Mockito.verify(placementAreaService)
                .placementAreaExist(1L);

        Mockito.verify(luggagePersistence)
                .findAllByPlacementAreaId(1L);

        Assertions.assertThat(luggageListResponse)
                .extracting(LuggageDto::getPlacementArea)
                .extracting(PlacementAreaDto::getId)
                .contains(1L);
    }

    @Test
    void GivenNonExistLuggageId_WhenDelete_ShouldThrowException() {
        Mockito.when(luggagePersistence.luggageExist(1L))
                .thenReturn(false);

        Exception exception = assertThrows(
                NoSuchElementException.class,
                () -> luggageService.delete(1L));

        Assertions.assertThat(exception.getMessage())
                .contains("Luggage does not exist");
    }

}

package com.udea.sitas.persistence.component;

import com.udea.sitas.dao.entity.Luggage;
import com.udea.sitas.dao.entity.PlacementArea;
import com.udea.sitas.dao.repository.LuggageRepository;
import com.udea.sitas.dao.repository.PlacementAreaRepository;
import com.udea.sitas.persistence.dto.LuggageDto;
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
class LuggagePersistenceImplTest {

    @InjectMocks
    private LuggagePersistenceImpl luggagePersistence;

    @Mock
    private LuggageRepository luggageRepository;
    @Mock
    private PlacementAreaRepository placementAreaRepository;

    @Spy
    private ModelMapper modelMapper;

    PlacementAreaDto placementAreaDtoTest = PlacementAreaDto.builder()
            .id(1L)
            .name("Area test")
            .build();

    PlacementArea placementAreaTest = PlacementArea.builder()
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
            .placementArea(placementAreaDtoTest)
            .build();

    Luggage luggage1 = Luggage.builder()
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

    Luggage luggage2 = Luggage.builder()
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

    List<Luggage> luggageList = List.of(luggage1,luggage2);

    @Test
    void GivenLuggageDto_WhenSave_ShouldReturnSaved() {

        Mockito.when(luggageRepository.save(Mockito.any(Luggage.class)))
                .thenAnswer(invocationOnMock -> {
                    Luggage luggageSaved = invocationOnMock.getArgument(0);
                    luggageSaved.setId(1L);
                    return luggageSaved;
                });

        final LuggageDto luggageDtoSaved = luggagePersistence.save(luggageDtoToSave);

        Mockito.verify(luggageRepository)
                .save(Mockito.any(Luggage.class));

        Assertions.assertThat(luggageDtoSaved)
                .hasFieldOrPropertyWithValue("id", 1L);
    }

    @Test
    void WhenFindAll_ShouldReturnDtoList() {
        Mockito.when(luggageRepository.findAll())
                .thenReturn(luggageList);

        final List<LuggageDto> luggageDtoListResponse = luggagePersistence.findAll();

        Mockito.verify(luggageRepository)
                .findAll();

        Assertions.assertThat(luggageDtoListResponse)
                .extracting(LuggageDto::getId)
                .contains(1L, 2L);
    }

    @Test
    void GivenLuggageId_WhenFindById_ShouldReturnLuggageWithId() {
        Mockito.when(luggageRepository.findById(1L))
                .thenReturn(Optional.of(luggage1));

        final LuggageDto luggageDtoResponse = luggagePersistence.findById(1L);

        Mockito.verify(luggageRepository)
                .findById(1L);

        Assertions.assertThat(luggageDtoResponse)
                .hasFieldOrPropertyWithValue("id", 1L);
    }

    @Test
    void GivenLuggageId_WhenDelete() {

        Mockito.when(luggageRepository.findById(1L))
                        .thenReturn(Optional.of(luggage1));

        luggagePersistence.delete(1L);

        Mockito.verify(luggageRepository)
                .delete(luggage1);
    }

    @Test
    void GivenLuggageId_WhenCheckIfExist_ShouldReturnTrue() {
        Mockito.when(luggageRepository.existsById(1L))
                .thenReturn(true);

        final boolean luggageExist = luggagePersistence.luggageExist(1L);

        Mockito.verify(luggageRepository)
                .existsById(1L);

        Assertions.assertThat(luggageExist)
                .isTrue();
    }

    @Test
    void GivenPlacementAreaId_WhenFindByPlacementAreaId_ShouldReturnAllLuggageWithPlacementAreaId() {

        Mockito.when(placementAreaRepository.findById(1L))
                        .thenReturn(Optional.of(placementAreaTest));

        Mockito.when(luggageRepository.findByPlacementArea(placementAreaTest))
                .thenReturn(luggageList);

        final List<LuggageDto> luggageListResponse = luggagePersistence.findAllByPlacementAreaId(1L);

        Mockito.verify(placementAreaRepository)
                .findById(1L);

        Mockito.verify(luggageRepository)
                .findByPlacementArea(placementAreaTest);

        Assertions.assertThat(luggageListResponse)
                .extracting(LuggageDto::getPlacementArea)
                .extracting(PlacementAreaDto::getId)
                .contains(1L);
    }
}

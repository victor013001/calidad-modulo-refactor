package com.udea.sitas.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.sitas.persistence.dto.LuggageDto;
import com.udea.sitas.persistence.dto.PlacementAreaDto;
import com.udea.sitas.service.component.LuggageService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class LuggageControllerTest {

    private static final String BASE_ENDPOINT = "/luggage";

    @InjectMocks
    private LuggageController luggageController;

    @Mock
    private LuggageService luggageService;

    private MockMvc mockMvc;

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

    List<LuggageDto> luggageDtoList = List.of(luggageDto1,luggageDto2);

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(luggageController).build();
    }

    @Test
    void GivenLuggageDtoRequest_WhenCreate_ShouldReturnLuggageDtoCreatedAndStatusCreated() throws Exception {
        LuggageDto luggageDtoSaved = luggageDtoToSave;
        luggageDtoSaved.setId(1L);

        String luggageToSaveJson = new ObjectMapper()
                .writeValueAsString(luggageDtoToSave);

        Mockito.when(luggageService.create(luggageDtoToSave))
                .thenReturn(luggageDtoSaved);

        ResultActions response =  mockMvc.perform(MockMvcRequestBuilders.post(BASE_ENDPOINT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(luggageToSaveJson));

        Mockito.verify(luggageService)
                        .create(luggageDtoToSave);

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }

    @Test
    void WhenGetAll_ShouldReturnLuggageListAndStatusOk() throws Exception {
        Mockito.when(luggageService.findAll())
                .thenReturn(luggageDtoList);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(BASE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L));

    }

    @Test
    void GivenLuggageId_WhenGet_ShouldReturnLuggageAndStatusOk() throws Exception {
        Mockito.when(luggageService.findById(1L))
                .thenReturn(luggageDto1);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(BASE_ENDPOINT+"/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(luggageService)
                        .findById(1L);

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }

    @Test
    void GivenLuggageId_WhenDelete_ShouldReturnStatusNoContent() throws Exception {
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.delete(BASE_ENDPOINT+"/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(luggageService)
                .delete(1L);

        response.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void GivenLuggageUpdatedAndLuggageToUpdateId_WhenUpdate_ShouldReturnLuggageUpdatedAndStatusOk() throws Exception {
        LuggageDto luggageDtoUpdated = luggageDtoToUpdate;
        luggageDtoToUpdate.setId(1L);

        String luggageToUpdateJson = new ObjectMapper()
                .writeValueAsString(luggageDtoToUpdate);

        Mockito.when(luggageService.update(luggageDtoUpdated, 1L))
                .thenReturn(luggageDtoUpdated);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.put(BASE_ENDPOINT+"/{id}", 1L)
                .content(luggageToUpdateJson)
                .contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(luggageService)
                .update(luggageDtoToUpdate, 1L);

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(Matchers.is("Updated Luggage")));
    }

    @Test
    void GivenPlacementAreaId_WhenGet_ShouldReturnLuggageListAndStatusOk() throws Exception {
        Mockito.when(luggageService.findByPlacementAreaId(1L))
                .thenReturn(luggageDtoList);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(BASE_ENDPOINT+"/placement-area/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(luggageService)
                .findByPlacementAreaId(1L);

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].placementArea.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].placementArea.id").value(1L));
    }



}

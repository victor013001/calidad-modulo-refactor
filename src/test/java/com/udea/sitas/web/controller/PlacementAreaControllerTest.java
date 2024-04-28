package com.udea.sitas.web.controller;

import com.udea.sitas.persistence.dto.PlacementAreaDto;
import com.udea.sitas.service.component.PlacementAreaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
public class PlacementAreaControllerTest {

    private static final String BASE_ENDPOINT = "/placement-area";

    @InjectMocks
    private PlacementAreaController placementAreaController;

    @Mock
    private PlacementAreaService placementAreaService;

    private MockMvc mockMvc;

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

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(placementAreaController).build();
    }

    @Test
    void WhenGetAll_ShouldReturnPlacementAreaListAndStatusOk() throws Exception {
        Mockito.when(placementAreaService.findAll())
                .thenReturn(placementAreaDtoList);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(BASE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3L));
    }

    @Test
    void GivenLuggageId_WhenGet_ShouldReturnLuggageAndStatusOk() throws Exception {
        Mockito.when(placementAreaService.findById(1L))
                .thenReturn(placementAreaTest1);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(BASE_ENDPOINT+"/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON));

        Mockito.verify(placementAreaService)
                .findById(1L);

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }
}

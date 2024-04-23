package com.udea.sitas.web.controller;

import com.udea.sitas.persistence.dto.PlacementAreaDto;
import com.udea.sitas.service.component.PlacementAreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/placement-area")
@RequiredArgsConstructor
public class PlacementAreaController {

    private final PlacementAreaService placementAreaService;

    @Operation(summary = "Get all placement areas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Placement areas found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PlacementAreaDto.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @GetMapping
    public List<PlacementAreaDto> findAll() {
        return placementAreaService.findAll();
    }

    @Operation(summary = "Get a placement area by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Placement area found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PlacementAreaDto.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @GetMapping("/{id}")
    public PlacementAreaDto findById(
            @PathVariable Long id
    ) {
        return placementAreaService.findById(id);
    }

}

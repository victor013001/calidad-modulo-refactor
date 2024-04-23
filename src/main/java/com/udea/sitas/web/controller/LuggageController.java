package com.udea.sitas.web.controller;

import com.udea.sitas.persistence.dto.LuggageDto;
import com.udea.sitas.service.component.LuggageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/luggage")
@RequiredArgsConstructor
public class LuggageController {

    private final LuggageService luggageService;

    @Operation(summary = "Create a new luggage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Luggage created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @PostMapping
    public LuggageDto create(
            @RequestBody @Valid LuggageDto luggageRequest
    ) {
        return luggageService.create(luggageRequest);
    }

    @Operation(summary = "Get all luggages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Luggages found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageDto.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @GetMapping
    public List<LuggageDto> findAll() {
        return luggageService.findAll();
    }

    @Operation(summary = "Get a luggage by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Luggage found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageDto.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @GetMapping("/{id}")
    public LuggageDto findById(
            @PathVariable Long id
    ) {
        return luggageService.findById(id);
    }

    @Operation(summary = "Delete a luggage by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Luggage deleted", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Luggage not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        luggageService.delete(id);
    }

    @Operation(summary = "Update a luggage by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Luggage updated", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Luggage not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @PutMapping("/{id}")
    public LuggageDto update(
            @RequestBody @Valid LuggageDto luggageRequest,
            @PathVariable Long id
    ) {
        return luggageService.update(luggageRequest, id);
    }

    @Operation(summary = "Get all luggages by a specific placement area")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Luggages found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = LuggageDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Luggages not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @GetMapping("/placement-area/{id}")
    public List<LuggageDto> findByPlacementArea(
            @PathVariable Long id
    ) {
        return luggageService.findByPlacementAreaId(id);
    }

}

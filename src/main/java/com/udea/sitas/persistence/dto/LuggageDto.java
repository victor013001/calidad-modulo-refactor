package com.udea.sitas.persistence.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LuggageDto {
    private Long id;

    @NotBlank
    private String type;

    @DecimalMin(value = "0", message = "Extra charge should not be less than 0")
    private Double extraCharge;

    @Min(value = 1, message = "Quantity should not be less than 1")
    private Integer quantity;

    @DecimalMin(value = "0", inclusive = false, message = "Width must be greater than 0")
    private Double width;

    @DecimalMin(value = "0", inclusive = false, message = "Height must be greater than 0")
    private Double height;

    @DecimalMin(value = "0", inclusive = false, message = "Length must be greater than 0")
    private Double length;

    @DecimalMin(value = "0", inclusive = false, message = "Weight must be greater than 0")
    private Double weight;

    private String description;

    @NotNull
    private Long userId;

    @NotNull
    private Long flightId;

    @NotNull
    private Long bookingId;

    private PlacementAreaDto placementArea;
}

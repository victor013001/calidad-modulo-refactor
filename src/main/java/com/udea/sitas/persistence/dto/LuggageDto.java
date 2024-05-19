package com.udea.sitas.persistence.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("luggage_type")
    @NotBlank (message = "type")
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

    @JsonProperty("user_id")
    @NotNull (message = "user id")
    private Long userId;

    @JsonProperty("flight_id")
    @NotNull (message = "fligthId")
    private Long flightId;

    @JsonProperty("booking_id")
    @NotNull (message = "bookid")
    private Long bookingId;

    @JsonProperty("placement_area_id")
    private Long placementAreaId;
}

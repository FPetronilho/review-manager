package com.tracktainment.reviewmanager.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;

public class RatingSummary {

    @Schema(description = "Unique identifier of the entity", example = "123e4567-e89b-12d3-a456-426614174000")
    private String entityId;

    @Schema(description = "Type of entity", example = "Book")
    private String entityType;

    @Schema(description = "Average rating", example = "4.1")
    private double averageRating;

    @Schema(description = "Total reviews", example = "57")
    private int totalReviews;

    @Schema(description = "Rating distribution", example = "{5: 10, 4: 5, 3: 2, 2: 1, 1: 0}")
    private Map<Integer, Integer> ratingDistribution; // e.g. {5: 10, 4: 5, 3: 2, 2: 1, 1: 0}
}

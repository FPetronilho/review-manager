package com.tracktainment.reviewmanager.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Review information")
public class Review {

    @Schema(description = "Unique identifier of the review", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Unique identifier of the user", example = "123e4567-e89b-12d3-a456-426614174000")
    private String userId;

    @Schema(description = "Unique identifier of the entity", example = "123e4567-e89b-12d3-a456-426614174000")
    private String entityId; // ID of the reviewed entity (book, game, etc.)

    @Schema(description = "Type of entity", example = "Book")
    private String entityType; // Type of entity ("book", "game", etc.)

    @Schema(description = "Rating of the reviewed entity", example = "5")
    private float rating;

    @Schema(description = "Title of the review", example = "Captivating story with rich character development")
    private String title;

    @Schema(
            description = "Content of the review",
            example = "This book offers an engaging narrative with well-developed" +
            " characters and a compelling plot. The author's vivid descriptions create an immersive reading experience. " +
            "Highly recommended for fans of historical fiction"
    )
    private String content;


    @Schema(description = "Review creation timestamp", example = "2023-01-15T12:34:56")
    private LocalDateTime createdAt;

    @Schema(description = "Review last update timestamp", example = "2023-02-20T15:45:30")
    private LocalDateTime updatedAt;
}

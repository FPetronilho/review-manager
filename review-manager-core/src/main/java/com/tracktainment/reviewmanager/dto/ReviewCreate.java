package com.tracktainment.reviewmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tracktainment.reviewmanager.util.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Data for creating a new review")
public class ReviewCreate {

    @NotNull(message = Constants.ENTITY_ID_MANDATORY_MSG)
    @Pattern(regexp = Constants.TITLE_REGEX, message = Constants.ID_INVALID_MSG)
    @Schema(description = "Unique identifier of the entity", example = "123e4567-e89b-12d3-a456-426614174000")
    private String entityId; // ID of the reviewed entity (book, game, etc.)

    @NotNull(message = Constants.ENTITY_TYPE_MANDATORY_MSG)
    @Pattern(regexp = Constants.TYPE_REGEX, message = Constants.TYPE_INVALID_MSG)
    @Schema(description = "Type of entity", example = "Book")
    private String entityType; // Type of entity ("book", "game", etc.)

    @NotNull(message = Constants.RATING_MANDATORY_MSG)
    @Min(value = 1, message = Constants.RATING_INVALID_MSG)
    @Max(value = 5, message = Constants.RATING_INVALID_MSG)
    @Schema(description = "Rating of the reviewed entity", example = "5")
    private float rating;

    @Pattern(regexp = Constants.TITLE_REGEX, message = Constants.TITLE_INVALID_MSG)
    @Schema(description = "Title of the review", example = "Captivating story with rich character development")
    private String title;

    @Pattern(regexp = Constants.CONTENT_REGEX, message = Constants.CONTENT_INVALID_MSG)
    @Schema(
            description = "Content of the review",
            example = "This book offers an engaging narrative with well-developed" +
                    " characters and a compelling plot. The author's vivid descriptions create an immersive reading experience. " +
                    "Highly recommended for fans of historical fiction"
    )
    private String content;
}

package com.tracktainment.reviewmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tracktainment.reviewmanager.util.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Schema(description = "Data for updating a review")
public class ReviewUpdate {

    @Min(value = 1, message = Constants.RATING_INVALID_MSG)
    @Max(value = 5, message = Constants.RATING_INVALID_MSG)
    @Schema(description = "Rating of the reviewed entity", example = "5")
    private int rating;

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

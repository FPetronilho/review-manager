package com.tracktainment.reviewmanager.api;

import com.tracktainment.reviewmanager.domain.OrderBy;
import com.tracktainment.reviewmanager.domain.OrderDirection;
import com.tracktainment.reviewmanager.domain.Review;
import com.tracktainment.reviewmanager.dto.ReviewCreate;
import com.tracktainment.reviewmanager.dto.ReviewUpdate;
import com.tracktainment.reviewmanager.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("api/v1/reviews")
@Validated
@Tag(name = "Reviews", description = "Review Manager APIs")
public interface ReviewRestApi {

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Create a new review",
            description = "Creates a new review with the provided details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Review created successfully",
                    content = @Content(schema = @Schema(implementation = Review.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Review already exists")
    })
    ResponseEntity<Review> create(@RequestBody @Valid ReviewCreate reviewCreate);

    @GetMapping(
            path ="/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Find a review by ID",
            description = "Returns a review based on its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review found",
                    content = @Content(schema = @Schema(implementation = Review.class))),
            @ApiResponse(responseCode = "404", description = "Review not found")
    })
    ResponseEntity<Review> findById(
            @Parameter(description = "Review ID", required = true)
            @PathVariable @Pattern(regexp = Constants.ID_REGEX, message = Constants.ID_INVALID_MSG) String id
    );

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "List reviews by criteria",
            description = "Returns a list of reviews filtered by various criteria"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of reviews",
                    content = @Content(schema = @Schema(implementation = Review.class)))
    })
    ResponseEntity<List<Review>> listByCriteria(
            @Parameter(description = "Result offset (pagination)")
            @RequestParam(required = false, defaultValue = Constants.DEFAULT_OFFSET)
            @Min(value = Constants.MIN_OFFSET, message = Constants.OFFSET_INVALID_MSG) Integer offset,

            @Parameter(description = "Maximum number of results to return")
            @RequestParam(required = false, defaultValue = Constants.DEFAULT_LIMIT)
            @Min(value = Constants.MIN_LIMIT, message = Constants.LIMIT_INVALID_MSG)
            @Max(value = Constants.MAX_LIMIT, message = Constants.LIMIT_INVALID_MSG) Integer limit,

            @Parameter(description = "Filter by IDs (comma-separated)")
            @RequestParam(required = false)
            @Pattern(regexp = Constants.ID_LIST_REGEX, message = Constants.IDS_INVALID_MSG) String ids,

            @Parameter(description = "Filter by user ID")
            @RequestParam(required = false)
            @Pattern(regexp = Constants.ID_REGEX, message = Constants.ID_INVALID_MSG) String userId,

            @Parameter(description = "Filter by entity ID")
            @RequestParam(required = false)
            @Pattern(regexp = Constants.ID_REGEX, message = Constants.ID_INVALID_MSG) String entityId,

            @Parameter(description = "Filter by entity type")
            @RequestParam(required = false)
            @Pattern(regexp = Constants.TYPE_REGEX, message = Constants.TYPE_INVALID_MSG) String entityType,

            @Parameter(description = "Filter by rating")
            @RequestParam(required = false)
            @Min(value = Constants.MIN_RATING, message = Constants.RATING_INVALID_MSG)
            @Max(value = Constants.MAX_RATING, message = Constants.RATING_INVALID_MSG) float rating,

            @Parameter(description = "Filter by creation date")
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createdAt,

            @Parameter(description = "Filter by date range start")
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,

            @Parameter(description = "Filter by date range end")
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,

            @Parameter(description = "Order by fields")
            @RequestParam(required = false, defaultValue = Constants.DEFAULT_ORDER) List<OrderBy> orderByList,

            @Parameter(description = "Order direction for each field")
            @RequestParam(required = false, defaultValue = Constants.DEFAULT_DIRECTION) List<OrderDirection> orderDirectionList
    );

    @PatchMapping(
            path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Update a review",
            description = "Updates an existing review with the provided details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Review updated successfully",
                    content = @Content(schema = @Schema(implementation = Review.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Review not found")
    })
    ResponseEntity<Review> update(
            @Parameter(description = "Review ID", required = true)
            @PathVariable @Pattern(regexp = Constants.ID_REGEX, message = Constants.ID_INVALID_MSG) String id,

            @RequestBody @Valid ReviewUpdate reviewUpdate
    );
    @DeleteMapping(path = "/{id}")
    @Operation(
            summary = "Delete a review",
            description = "Deletes a review based on its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Review deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Review not found")
    })
    ResponseEntity<Void> delete(
            @Parameter(description = "Review ID", required = true)
            @PathVariable @Pattern(regexp = Constants.ID_REGEX, message = Constants.ID_INVALID_MSG) String id
    );
}

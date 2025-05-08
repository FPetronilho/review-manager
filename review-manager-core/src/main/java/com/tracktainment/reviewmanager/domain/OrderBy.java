package com.tracktainment.reviewmanager.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@Schema(description = "Field sorting options")
public enum OrderBy {

    @Schema(description = "Sort by entity")
    ENTITY("entity"),

    @Schema(description = "Sort by user")
    USER("user"),

    @Schema(description = "Sort by creation date")
    CREATED_AT("createdAt");

    private final String value;
}
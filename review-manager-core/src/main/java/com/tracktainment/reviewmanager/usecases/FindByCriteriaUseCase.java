package com.tracktainment.reviewmanager.usecases;

import com.tracktainment.reviewmanager.dataprovider.ReviewDataProvider;
import com.tracktainment.reviewmanager.domain.OrderBy;
import com.tracktainment.reviewmanager.domain.OrderDirection;
import com.tracktainment.reviewmanager.domain.Review;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindByCriteriaUseCase {

    private final ReviewDataProvider reviewDataProvider;

    public Output execute(Input input) {
        return Output.builder()
                .reviews(reviewDataProvider.findByCriteria(input))
                .build();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Input {
        private String jwt;
        private Integer offset;
        private Integer limit;
        private String ids;
        private String userId;
        private String entityId;
        private String entityType;
        private float rating;
        private LocalDate createdAt;
        private LocalDate from;
        private LocalDate to;
        private List<OrderBy> orderByList;
        private List<OrderDirection> orderDirectionList;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Output {
        private List<Review> reviews;
    }
}

package com.tracktainment.reviewmanager.usecases;

import com.tracktainment.reviewmanager.dataprovider.ReviewDataProvider;
import com.tracktainment.reviewmanager.domain.Review;
import com.tracktainment.reviewmanager.dto.ReviewUpdate;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateUseCase {

    private final ReviewDataProvider reviewDataProvider;

    public Output execute(Input input) {
        return Output.builder()
                .review(reviewDataProvider.update(
                        input.getId(),
                        input.getReviewUpdate()
                ))
                .build();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Input {
        private String jwt;
        private String id;
        private ReviewUpdate reviewUpdate;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Output {
        private Review review;
    }
}

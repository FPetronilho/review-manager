package com.tracktainment.reviewmanager.usecases;

import com.tracktainment.reviewmanager.dataprovider.ReviewDataProvider;
import com.tracktainment.reviewmanager.domain.Review;
import com.tracktainment.reviewmanager.dto.ReviewCreate;
import com.tracktainment.reviewmanager.security.util.SecurityUtil;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateUseCase {

    private final ReviewDataProvider reviewDataProvider;
    private final SecurityUtil securityUtil;

    public Output execute(Input input) {
        Review review = reviewDataProvider.create(input.getReviewCreate());
        review.setUserId(securityUtil.getDigitalUser().getId());

        return Output.builder()
                .review(review)
                .build();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Input {
        private String jwt;
        private ReviewCreate reviewCreate;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Output {
        private Review review;
    }
}

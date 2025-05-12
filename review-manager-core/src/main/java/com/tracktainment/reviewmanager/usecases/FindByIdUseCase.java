package com.tracktainment.reviewmanager.usecases;

import com.tracktainment.reviewmanager.dataprovider.ReviewDataProvider;
import com.tracktainment.reviewmanager.domain.Review;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindByIdUseCase {

    private final ReviewDataProvider reviewDataProvider;

    public Output execute(Input input) {
        return Output.builder()
                .review(reviewDataProvider.findById(input.getId()))
                .build();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Input {
        private String jwt;
        private String id;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Output {
        private Review review;
    }
}

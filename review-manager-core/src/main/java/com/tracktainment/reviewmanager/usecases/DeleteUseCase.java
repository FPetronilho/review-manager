package com.tracktainment.reviewmanager.usecases;

import com.tracktainment.reviewmanager.dataprovider.ReviewDataProvider;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteUseCase {

    private final ReviewDataProvider reviewDataProvider;

    public void execute(Input input) {
        reviewDataProvider.delete(input.getId());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Input {
        private String jwt;
        private String id;
    }
}

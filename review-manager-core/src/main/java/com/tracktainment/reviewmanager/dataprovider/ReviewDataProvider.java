package com.tracktainment.reviewmanager.dataprovider;

import com.tracktainment.reviewmanager.domain.RatingSummary;
import com.tracktainment.reviewmanager.domain.Review;
import com.tracktainment.reviewmanager.dto.ReviewCreate;
import com.tracktainment.reviewmanager.dto.ReviewUpdate;
import com.tracktainment.reviewmanager.usecases.FindByCriteriaUseCase;

import java.util.List;

public interface ReviewDataProvider {

    Review create(ReviewCreate reviewCreate);
    Review findById(String id);
    List<Review> findByCriteria(FindByCriteriaUseCase.Input input);
    Review update(String id, ReviewUpdate reviewUpdate);
    void delete(String id);
    RatingSummary getRatingSummary(String entityId, String entityType);
}
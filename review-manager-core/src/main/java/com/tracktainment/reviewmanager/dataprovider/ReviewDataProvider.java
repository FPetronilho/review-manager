package com.tracktainment.reviewmanager.dataprovider;

import com.tracktainment.reviewmanager.domain.RatingSummary;
import com.tracktainment.reviewmanager.domain.Review;
import com.tracktainment.reviewmanager.dto.ReviewCreate;
import com.tracktainment.reviewmanager.dto.ReviewUpdate;

import java.util.List;

public interface ReviewDataProvider {

    Review create(ReviewCreate reviewCreate);
    Review findById(String id);
    List<Review> findByEntityId(String entityId, String entityType);
    List<Review> findByUserId(String userId);
    Review update(String id, ReviewUpdate reviewUpdate);
    void delete(String id);
    RatingSummary getRatingSummary(String entityId, String entityType);
}
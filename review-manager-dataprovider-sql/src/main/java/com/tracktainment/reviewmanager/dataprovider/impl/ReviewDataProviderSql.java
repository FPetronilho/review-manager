package com.tracktainment.reviewmanager.dataprovider.impl;

import com.tracktainment.reviewmanager.dataprovider.ReviewDataProvider;
import com.tracktainment.reviewmanager.domain.RatingSummary;
import com.tracktainment.reviewmanager.domain.Review;
import com.tracktainment.reviewmanager.dto.ReviewCreate;
import com.tracktainment.reviewmanager.dto.ReviewUpdate;
import com.tracktainment.reviewmanager.mapper.ReviewMapperDataProvider;
import com.tracktainment.reviewmanager.repository.ReviewRepository;
import com.tracktainment.reviewmanager.usecases.FindByCriteriaUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewDataProviderSql implements ReviewDataProvider {

    private final ReviewRepository reviewRepository;
    private final ReviewMapperDataProvider mapper;


    @Override
    @Transactional
    public Review create(ReviewCreate reviewCreate) {
        return null;
    }

    @Override
    public Review findById(String id) {
        return null;
    }

    @Override
    public List<Review> findByCriteria(FindByCriteriaUseCase.Input input) {
        return null;
    }

    @Override
    @Transactional
    public Review update(String id, ReviewUpdate reviewUpdate) {
        return null;
    }

    @Override
    @Transactional
    public void delete(String id) {

    }

    @Override
    public RatingSummary getRatingSummary(String entityId, String entityType) {
        return null;
    }
}

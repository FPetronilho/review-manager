package com.tracktainment.reviewmanager.controller;

import com.tracktainment.reviewmanager.api.ReviewRestApi;
import com.tracktainment.reviewmanager.domain.OrderBy;
import com.tracktainment.reviewmanager.domain.OrderDirection;
import com.tracktainment.reviewmanager.domain.Review;
import com.tracktainment.reviewmanager.dto.ReviewCreate;
import com.tracktainment.reviewmanager.dto.ReviewUpdate;
import com.tracktainment.reviewmanager.exception.ParameterValidationFailedException;
import com.tracktainment.reviewmanager.usecases.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@Slf4j
public class ReviewController implements ReviewRestApi {

    private final CreateUseCase createUseCase;
    private final FindByIdUseCase findByIdUseCase;
    private final FindByCriteriaUseCase findByCriteriaUseCase;
    private final UpdateUseCase updateUseCase;
    private final DeleteUseCase deleteUseCase;
    private final HttpServletRequest httpServletRequest;

    @Override
    public ResponseEntity<Review> create(ReviewCreate reviewCreate) {
        log.info("Creating review: {}.", reviewCreate);
        String jwt = httpServletRequest.getHeader("Authorization");

        CreateUseCase.Input input = CreateUseCase.Input.builder()
                .jwt(jwt)
                .reviewCreate(reviewCreate)
                .build();

        CreateUseCase.Output output = createUseCase.execute(input);
        return new ResponseEntity<>(output.getReview(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Review> findById(String id) {
        log.info("Finding review: {}.", id);
        String jwt = httpServletRequest.getHeader("Authorization");

        FindByIdUseCase.Input input = FindByIdUseCase.Input.builder()
                .jwt(jwt)
                .id(id)
                .build();

        FindByIdUseCase.Output output = findByIdUseCase.execute(input);
        return new ResponseEntity<>(output.getReview(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Review>> listByCriteria(
            Integer offset,
            Integer limit,
            String ids,
            String userId,
            String entityId,
            String entityType,
            float rating,
            LocalDate createdAt,
            LocalDate from,
            LocalDate to,
            List<OrderBy> orderByList,
            List<OrderDirection> orderDirectionList
    ) {
        // Input treatment
        if (createdAt != null) {
            from = null;
            to = null;
        }

        // Input validation
        if (to != null && from != null && to.isBefore(from)) {
            throw new ParameterValidationFailedException("Invalid dates input: 'to' must be 'later' than from");
        }

        if (orderByList.size() != orderDirectionList.size()) {
            throw new ParameterValidationFailedException(String.format(
                    "Invalid orderBy and orderDirection pair. " +
                            "'orderBy' size is %s and orderDirection size is %s. Both sizes must match",
                    orderByList.size(),
                    orderDirectionList.size()
            ));
        }

        // Get JWT
        String jwt = httpServletRequest.getHeader("Authorization");

        FindByCriteriaUseCase.Input input = FindByCriteriaUseCase.Input.builder()
                .jwt(jwt)
                .offset(offset)
                .limit(limit)
                .ids(ids)
                .userId(userId)
                .entityId(entityId)
                .entityType(entityType)
                .rating(rating)
                .createdAt(createdAt)
                .from(from)
                .to(to)
                .orderByList(orderByList)
                .orderDirectionList(orderDirectionList)
                .build();

        log.info("Listing reviews by criteria: {}.", input);
        FindByCriteriaUseCase.Output output = findByCriteriaUseCase.execute(input);
        return new ResponseEntity<>(output.getReviews(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Review> update(String id, ReviewUpdate reviewUpdate) {
        log.info("Updating review: {}. Updated review data: {}.", id, reviewUpdate);
        String jwt = httpServletRequest.getHeader("Authorization");

        UpdateUseCase.Input input = UpdateUseCase.Input.builder()
                .jwt(jwt)
                .id(id)
                .reviewUpdate(reviewUpdate)
                .build();

        UpdateUseCase.Output output = updateUseCase.execute(input);
        return new ResponseEntity<>(output.getReview(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        log.info("Deleting review: {}.", id);
        String jwt = httpServletRequest.getHeader("Authorization");

        DeleteUseCase.Input input = DeleteUseCase.Input.builder()
                .jwt(jwt)
                .id(id)
                .build();

        deleteUseCase.execute(input);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

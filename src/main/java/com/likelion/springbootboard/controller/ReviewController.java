package com.likelion.springbootboard.controller;

import com.likelion.springbootboard.entity.Review;
import com.likelion.springbootboard.entity.dto.ReviewRequest;
import com.likelion.springbootboard.entity.dto.ReviewResponse;
import com.likelion.springbootboard.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/boards/{id}/reviews")
    public ReviewResponse add(@PathVariable("id") Long id, @RequestBody ReviewRequest reviewRequest) {
        return reviewService.addReview(id, reviewRequest);
    }

}

package com.likelion.springbootboard.controller;

import com.likelion.springbootboard.entity.Review;
import com.likelion.springbootboard.entity.dto.ReviewRequest;
import com.likelion.springbootboard.entity.dto.ReviewResponse;
import com.likelion.springbootboard.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewService reviewService;

    @PostMapping("/boards/{boardId}/reviews")
    public ReviewResponse add(@PathVariable("boardId") Long id, @RequestBody ReviewRequest reviewRequest) {
        return reviewService.addReview(id, reviewRequest);
    }

    @GetMapping("/boards/{boardId}/reviews")
    public List<Review> findAll(@PathVariable("boardId") Long boardId) {
        return reviewService.findAll(boardId);
    }

    @GetMapping("/reviews/{id}")
    public ReviewResponse findById(@PathVariable("id") Long id) {
        return  reviewService.findById(id);
    }

    @PatchMapping("/reviews/{id}")
    public ReviewResponse edit(@PathVariable("id") Long id,@RequestBody ReviewRequest dto) {
        return reviewService.editReview(id, dto);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        reviewService.deleteById(id);
        return ResponseEntity.ok().body("리뷰 삭제가 완료 되었습니다"); //
    }
}

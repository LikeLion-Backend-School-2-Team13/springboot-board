package com.likelion.springbootboard.service;

import com.likelion.springbootboard.entity.Board;
import com.likelion.springbootboard.entity.Review;
import com.likelion.springbootboard.entity.dto.ReviewRequest;
import com.likelion.springbootboard.entity.dto.ReviewResponse;
import com.likelion.springbootboard.exception.BoardException;
import com.likelion.springbootboard.exception.ErrorCode;
import com.likelion.springbootboard.repository.BoardRepository;
import com.likelion.springbootboard.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BoardRepository boardRepository;

    public ReviewResponse addReview(Long id ,ReviewRequest reviewRequest) {
        Board board = boardRepository.findById(id).orElseThrow(()-> new BoardException(ErrorCode.NOT_FOUND,"해당 아이디 존재 하지 않습니다."));
        Review review = reviewRepository.save(reviewRequest.toEntity(board));
        return ReviewResponse.of(review);
    }


}

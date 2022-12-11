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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public ReviewResponse findById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()-> new BoardException(ErrorCode.NOT_FOUND,"아이디를 찾을 수 없습니다."));
        return ReviewResponse.of(review);
    }

    // List<Response> 로 바꿀수는 없을까?
    public List<Review> findAll(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new BoardException(ErrorCode.NOT_FOUND,"해당 아이디 존재 하지 않습니다."));
        List<Review> review = reviewRepository.findByBoard(board);
        return review;
    }

    @Transactional
    public ReviewResponse editReview(Long id, ReviewRequest dto) {
        Review review = reviewRepository.findById(id).orElseThrow(()-> new BoardException(ErrorCode.NOT_FOUND,"에러"));
        review.update(dto.toEntity());
        return ReviewResponse.of(review);
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}

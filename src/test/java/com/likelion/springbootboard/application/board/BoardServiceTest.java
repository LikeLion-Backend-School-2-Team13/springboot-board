package com.likelion.springbootboard.application.board;

import com.likelion.springbootboard.domain.board.Board;
import com.likelion.springbootboard.domain.board.BoardRepository;
import com.likelion.springbootboard.dto.board.BoardRequest;
import com.likelion.springbootboard.exception.notfound.BoardNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.likelion.springbootboard.support.fixture.BoardFixture.BOARD_1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    @Test
    void 게시글_저장() {
        final String AUTHOR = "홍길동";
        final String TITLE = "제목입니다.";
        final String CONTENT = "본문입니다.";
        final Long BOARD_ID = 1L;
        // given
        BoardRequest boardRequest = BOARD_1.request();

        Board board = BOARD_1.entity();

        given(boardRepository.save(any(Board.class))).willReturn(board);

        // when
        Long savedBoardId = boardService.saveBoard(boardRequest);

        // then
        assertEquals(BOARD_ID, savedBoardId);
        verify(boardRepository).save(any(Board.class));
    }

    @Test
    void 게시물_아이디로_검색_결과가_없는_경우_BoardNotFoundException() {
        Long id = 1L;

        given(boardRepository.findById(id)).willReturn(Optional.empty());

        assertThrows(BoardNotFoundException.class, () -> boardService.findById(id));
        verify(boardRepository).findById(id);
    }

    @Test
    void 게시물_수정_게시물이_없는_경우_BoardNotFoundException() {
        Long id = 1L;
        BoardRequest boardRequest = BOARD_1.request();

        given(boardRepository.findById(id)).willReturn(Optional.empty());

        assertThrows(BoardNotFoundException.class, () -> boardService.editBoard(id, boardRequest));
        verify(boardRepository).findById(id);
    }
}
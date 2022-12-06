package com.likelion.springbootboard.exception.notfound;

import com.likelion.springbootboard.exception.AbstractHttpErrorException;
import com.likelion.springbootboard.exception.ErrorCode;

public class BoardNotFoundException extends AbstractHttpErrorException {
    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}

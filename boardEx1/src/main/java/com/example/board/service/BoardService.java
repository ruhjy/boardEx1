package com.example.board.service;

import com.example.board.domain.Board;
import com.example.board.dto.BoardRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.exception.CustomException;
import com.example.board.exception.ErrorCode;
import com.example.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public Long save(final BoardRequestDto params) {
        Board savedBoard = boardMapper.save(params.toEntity());
        return savedBoard.getId();
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll() {
        List<Board> boardList = boardMapper.findAll();
        return boardList.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    public Long update(final Long id, final BoardRequestDto params) {
        Board findBoard = boardMapper.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        findBoard.update(params.getTitle(), params.getContent(), params.getWriter());
        boardMapper.update(findBoard);
        return id;
    }

}

package com.example.board.dto;

import com.example.board.domain.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private Integer hits;
    private char delete_yn;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    protected BoardResponseDto() {
    }

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.hits = board.getHits();
        this.delete_yn = board.getDelete_yn();
        this.created_date = board.getCreated_date();
        this.modified_date = board.getModified_date();
    }
}

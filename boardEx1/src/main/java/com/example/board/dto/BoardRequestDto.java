package com.example.board.dto;

import com.example.board.domain.Board;
import lombok.Getter;

@Getter
public class BoardRequestDto {

    private String title;
    private String content;
    private String writer;
    private char delete_yn;

    protected BoardRequestDto() {
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .hits(0)
                .delete_yn(delete_yn)
                .build();
    }
}

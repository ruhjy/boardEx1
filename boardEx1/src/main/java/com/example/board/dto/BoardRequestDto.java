package com.example.board.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {

    private String title;
    private String content;
    private String writer;
    private char delete_yn;

    protected BoardRequestDto() {
    }

}

package com.example.board.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Board {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private Integer hits;
    private Character delete_yn;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Board() {
    }

    @Builder
    public Board(String title, String content, String writer, Integer hits, Character delete_yn) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.delete_yn = delete_yn;
    }
}

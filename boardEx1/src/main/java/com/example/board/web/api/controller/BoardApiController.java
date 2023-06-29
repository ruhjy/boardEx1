package com.example.board.web.api.controller;

import com.example.board.exception.CustomException;
import com.example.board.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardApiController {

    @GetMapping("/test")
    public String test() {
        throw new RuntimeException("RuntimeException..");
    }

    @GetMapping("/test2")
    public String test2() {
        throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
    }
}

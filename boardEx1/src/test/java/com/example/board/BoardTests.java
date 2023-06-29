package com.example.board;

import com.example.board.domain.Board;
import com.example.board.mapper.BoardMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BoardTests {

    @Autowired
    private BoardMapper boardMapper;

    @BeforeEach
    void beforeEach() {
        boardMapper.deleteAll();
    }

    @Test
    void saveTest() {
        Board params = Board.builder()
                .title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .writer("1번 게시글 작성자")
                .hits(0)
                .delete_yn('N')
                .build();

        boardMapper.save(params);

        Long boardId = params.getId();
        Board findBoard = boardMapper.findById(boardId).get();

        assertThat(findBoard.getTitle()).isEqualTo("1번 게시글 제목");
        assertThat(findBoard.getContent()).isEqualTo("1번 게시글 내용");
        assertThat(findBoard.getWriter()).isEqualTo("1번 게시글 작성자");
    }

    @Test
    void findAllTest() {
        Board params1 = Board.builder()
                .title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .writer("1번 게시글 작성자")
                .hits(0)
                .delete_yn('N')
                .build();

        Board params2 = Board.builder()
                .title("2번 게시글 제목")
                .content("2번 게시글 내용")
                .writer("2번 게시글 작성자")
                .hits(0)
                .delete_yn('N')
                .build();

        boardMapper.save(params1);
        boardMapper.save(params2);

        List<Board> boards = boardMapper.findAll();

        assertThat(boards.size()).isEqualTo(2);
    }
}

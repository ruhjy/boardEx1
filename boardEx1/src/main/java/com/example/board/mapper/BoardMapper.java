package com.example.board.mapper;

import com.example.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    Board save(Board board);

    Optional<Board> findById(Long id);

    List<Board> findAll();

    void update(Board board);

    void deleteById(Long id);

    void deleteAll();
}

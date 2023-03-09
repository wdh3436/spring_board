package com.daehan.board.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daehan.board.domain.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	List<BoardEntity> findByTitleContaining(String keyword);
}

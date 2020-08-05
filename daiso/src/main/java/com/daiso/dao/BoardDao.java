package com.daiso.dao;

import java.util.List;
import java.util.Map;

import com.daiso.vo.BoardVO;

public interface BoardDao {
	void create(BoardVO board);
	List<BoardVO> read(int num);
	List<BoardVO> readAll();
	void update(BoardVO board);
	void delete(int b_num);
	
}

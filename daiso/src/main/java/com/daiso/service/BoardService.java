package com.daiso.service;

import java.util.List;

import com.daiso.vo.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO board);
	List<BoardVO> selectBoard(int num);
	List<BoardVO> selectAllBoards();
	void updateBoard(BoardVO board);
	void deleteBoard(int b_num);

}

package com.daiso.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiso.dao.BoardDao;
import com.daiso.dao.BoardDaoImpl;
import com.daiso.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public void insertBoard(BoardVO board) {
		boardDao.create(board);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> selectBoard(int num) {
		// TODO Auto-generated method stub
		return boardDao.read(num);
		
	}

	@Override
	public List<BoardVO> selectAllBoards(){
		// TODO Auto-generated method stub
		logger.info("영어 = " +boardDao.readAll().get(0).getM_userid());
		return boardDao.readAll();
	}

	@Override
	public void updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		boardDao.update(board);
	}

	@Override
	public void deleteBoard(int b_num) {
		// TODO Auto-generated method stub
		boardDao.delete(b_num);
	}

}

package com.daiso.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daiso.security.AccountService;
import com.daiso.vo.BoardVO;
import com.mapper.mapper.BoardMapper;


@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	
	private static final Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void create(BoardVO board) {
		boardMapper.insertBoard(board);
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardVO> read(int num) {
		return boardMapper.selectBoard(num);
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardVO> readAll() {
		// TODO Auto-generated method stub
		logger.info("한글 = " +boardMapper.selectAllBoard().get(0).getM_userid());
		return boardMapper.selectAllBoard();

	}

	@Override
	public void update(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.updateBoard(board);
	}

	@Override
	public void delete(int b_num) {
		// TODO Auto-generated method stub
		boardMapper.deleteBoard(b_num);
	}

}

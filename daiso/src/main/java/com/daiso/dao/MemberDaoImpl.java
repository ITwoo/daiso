package com.daiso.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daiso.vo.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void create(MemberVO member) {
		this.sqlSession.insert("memberInsert", member);
	}

	@Override
	public void read(Map map) {
		this.sqlSession.selectOne("memberSelect", map);		
	}

}

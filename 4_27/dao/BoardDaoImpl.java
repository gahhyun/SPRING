package com.earth.heart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.earth.heart.domain.BoardDTO;

@Repository
public class BoardDaoImpl implements BoardDao{		//2번째
	
	@Autowired
	private SqlSession session;		//<bean id="SqlSession" class="org.mybatis.spring.SqlSessionTemplate">
	private static String namespace = "com.earth.heart.dao.BoardMapper.";

	@Override
	public BoardDTO select(Integer bno) throws Exception {
		
		return session.selectOne(namespace + "select" , bno);
	}

	@Override
	public int deleteAll() throws Exception {
		
		return session.delete(namespace + "deleteAll");
	}

	@Override
	public int insert(BoardDTO dto) throws Exception {
	
		return session.insert(namespace + "insert", dto);
	}

	@Override
	public int count() throws Exception {

		return session.selectOne(namespace + "count");  //mapper로 이동
	}

	@Override
	public List<BoardDTO> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + "selectAll") ;
	}

	@Override
	public int delete(Integer bno, String writer) throws Exception {
		Map map = new HashMap();
		map.put("bno",bno);
		map.put("writer", writer);
		return session.delete(namespace + "delete", map);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return session.update(namespace + "update", boardDTO);
	}


}

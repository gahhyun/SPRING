package com.earth.heart.dao;

import com.earth.heart.domain.BoardDTO;

public interface BoardDao {	//1번째

	BoardDTO select(Integer bno) throws Exception;
	
	int insert(BoardDTO dto) throws Exception;
	
	int deleteAll() throws Exception;
	
	
	
	
	
}

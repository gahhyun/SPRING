package com.earth.heart.dao;

import java.util.List;
import java.util.Map;

import javax.swing.event.ListSelectionListener;

import com.earth.heart.domain.BoardDTO;


public interface BoardDao {	//1번째

	BoardDTO select(Integer bno) throws Exception;
	
	List<BoardDTO> selectPage(Map map) throws Exception;
	
	int insert(BoardDTO dto) throws Exception;
	
	int deleteAll() throws Exception;
	
	int delete(Integer bno, String writer) throws Exception;
	
	int count() throws Exception;
	
	List<BoardDTO> selectAll() throws Exception;
	
	int update(BoardDTO boardDTO) throws Exception;
	
	int increaseViewCnt(Integer bno) throws Exception;
	
	
}

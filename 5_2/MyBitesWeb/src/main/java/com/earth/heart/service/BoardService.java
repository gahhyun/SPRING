package com.earth.heart.service;

import java.util.List;
import java.util.Map;

import com.earth.heart.domain.BoardDTO;

public interface BoardService {		//비즈니스 로직 (구매,이체등의 용어 사용)
	
	List<BoardDTO> getPage(Map map) throws Exception;
	
	int getCount() throws Exception;
	
	BoardDTO  read(Integer bno) throws Exception;				//select
	
	int remove(Integer bno, String write) throws Exception;		//delete
	
	int write(BoardDTO boardDTO) throws Exception;				//insert
	
	int modify(BoardDTO boardDTO) throws Exception;				//update
	
		

}

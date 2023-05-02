package com.earth.heart.service;

import java.util.List;
import java.util.Map;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earth.heart.dao.BoardDao;
import com.earth.heart.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public List<BoardDTO> getPage(Map map) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectPage(map);
	}

	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.count();
	}

	@Override
	public BoardDTO read(Integer bno) throws Exception {
		BoardDTO boardDTO = boardDao.select(bno);
		//비즈니스 로직추가(조회수 추가) -> 게시글을 클릭하면 조회수가 1증가함
		boardDao.increaseViewCnt(bno);
		return boardDTO;		
	}

	@Override
	public int remove(Integer bno, String write) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.delete(bno, write);
	}

	@Override
	public int write(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.insert(boardDTO);
	}

	@Override
	public int modify(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.update(boardDTO);
	}

}







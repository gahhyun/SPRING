package com.earth.heart;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earth.heart.dao.BoardDao;
import com.earth.heart.domain.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class BoardDaoImplTest {
	
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void selectTest() throws Exception {
		assertTrue(boardDao != null);
		System.out.println("boardDao = " + boardDao);
		
		BoardDTO boardDTO = boardDao.select(1);
		System.out.println("boardDTO = "+boardDTO);
		//assertTrue(boardDTO.getBno().equals(1));
	
		boardDao.deleteAll();
		
		boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		boardDao.insert(boardDTO);
		
		boardDTO = boardDao.select(2);
		System.out.println("boardDao = " + boardDao);
		assertTrue(boardDTO.getBno().equals(2));
		
		
	}
	
	

}

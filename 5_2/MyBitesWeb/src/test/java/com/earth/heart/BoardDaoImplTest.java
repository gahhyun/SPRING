package com.earth.heart;

import static org.junit.Assert.assertTrue;

import java.util.List;

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
	
	//@Test
	public void countTest() throws Exception{
		boardDao.deleteAll();
		assertTrue(boardDao.count() == 0); 	
		
		BoardDTO boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		assertTrue(boardDao.insert(boardDTO)==1);
		assertTrue(boardDao.count()==1);
		
		assertTrue(boardDao.insert(boardDTO)==1);
		assertTrue(boardDao.count()==2);
	}
	
	
	//@Test
	public void insertTest() throws Exception{
		boardDao.deleteAll();
		BoardDTO boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		assertTrue(boardDao.insert(boardDTO)==1);
		
		boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		assertTrue(boardDao.insert(boardDTO)==1);
		assertTrue(boardDao.count()==2);

		boardDao.deleteAll();
		boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		assertTrue(boardDao.insert(boardDTO)==1);
		assertTrue(boardDao.count()==1);
		
	}
	
	
	
	//@Test
	public void selectTest() throws Exception {
		assertTrue(boardDao != null);
		System.out.println("boardDao = " + boardDao);
		
		BoardDTO boardDTO = boardDao.select(7);
		System.out.println("boardDTO = "+boardDTO);
		assertTrue(boardDTO.getBno().equals(7));
	
		boardDao.deleteAll();
		
		boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		boardDao.insert(boardDTO);
		
		boardDTO = boardDao.select(8);
		System.out.println("boardDao = " + boardDao);
		assertTrue(boardDTO.getBno().equals(8));
		
	}
	
	//@Test
	public void selectAllTest() throws Exception {
		boardDao.deleteAll();
		assertTrue(boardDao.count()==0);
		
		List<BoardDTO> list = boardDao.selectAll();
		assertTrue(list.size()==0);
		
		BoardDTO boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		assertTrue(boardDao.insert(boardDTO)==1);
		
		list = boardDao.selectAll();
		assertTrue(list.size()==1);
		
		assertTrue(boardDao.insert(boardDTO)==1);
		list = boardDao.selectAll();
		assertTrue(list.size()==2);	
	}
	
	@Test
	public void deleteTest() throws Exception{
		boardDao.deleteAll();
		assertTrue(boardDao.count()==0);
		BoardDTO boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		assertTrue(boardDao.insert(boardDTO)==1);
		Integer bno = boardDao.selectAll().get(0).getBno();		//인덱스0번 즉, 가장 맨위에 있는 데이터를 선택
		assertTrue(boardDao.delete(bno, boardDTO.getWriter())==1);
		assertTrue(boardDao.count()==0);
		
		assertTrue(boardDao.insert(boardDTO)==1);
		bno = boardDao.selectAll().get(0).getBno();
		assertTrue(boardDao.delete(bno, boardDTO.getWriter() + "ea")==0);	//writer은 'earth'인데 +ea를 해줘서 삭젝 안됨
		assertTrue(boardDao.count()==1);
		
		assertTrue(boardDao.delete(bno, boardDTO.getWriter())==1);		//writer의 조건이 'earth'로 같으므로 삭제됨
		assertTrue(boardDao.count()==0);
		
		assertTrue(boardDao.insert(boardDTO)==1);		//데이터 넣기 1개
		bno = boardDao.selectAll().get(0).getBno();		//첫번째 데이터 선택
		assertTrue(boardDao.delete(bno+1, boardDTO.getWriter())==0);	//없는데이터 삭제
		assertTrue(boardDao.count()==1);	//삭제조건과 맞지 않아서 삭제가 안되서 그대로 갯수는 1개
	}
	
	@Test
	public void deleteAllTest() throws Exception {
		boardDao.deleteAll();
		assertTrue(boardDao.count()==0);
		BoardDTO boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		assertTrue(boardDao.insert(boardDTO)==1);
		assertTrue(boardDao.deleteAll()==1);
		assertTrue(boardDao.count()==0);
		
		boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		assertTrue(boardDao.insert(boardDTO)==1);
		assertTrue(boardDao.insert(boardDTO)==1);
		assertTrue(boardDao.deleteAll()==2);
		assertTrue(boardDao.count()==0);
	}
	
	@Test
	public void updateTest() throws Exception{
		boardDao.deleteAll();
		BoardDTO boardDTO = new BoardDTO("Pioneering", "Read for action", "earth");
		assertTrue(boardDao.insert(boardDTO)==1);
		
		Integer bno = boardDao.selectAll().get(0).getBno();
		System.out.println("bno = " + bno );
		boardDTO.setBno(bno);
		boardDTO.setTitle("yes i can");
		assertTrue(boardDao.update(boardDTO)==1);
		
		BoardDTO boardDTO2 = boardDao.select(bno);
		assertTrue(boardDTO.equals(boardDTO2));  //기존것과 업데이트 한 값과 동일함
		System.out.println("bno = " + bno );
	}

}

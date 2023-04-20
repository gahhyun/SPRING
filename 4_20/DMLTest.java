package com.earth.tdd;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class DMLTest {
	
	@Autowired		//DI(의존성 주입)
	DataSource ds;
	
	@Test
	public void springJdbcConnText() throws SQLException {
		Connection conn = ds.getConnection();
		System.out.println("conn = "+conn);
		
		assertTrue(conn != null);  			//괄호 안의 조건식이 true면 테스트 성공, 아니면 실패
	}
	
	
	//@Test
	public void insertUserTest() throws SQLException {
		User user = new User("earth" , "0629" , "earth" , "earth@gmail.com" , new Date(), "youtube" , new Date() );
		
		deleteAll();
		int rowCnt = insertUser(user);
		
		assertTrue(rowCnt ==1);
	}
		
	//사용자 정보를 t_user 테이블에 저장하는 메서드
	private int insertUser(User user) throws SQLException {
		Connection conn = ds.getConnection();
		
		/*
		 * 인파라미터에는 물음표를 사용함
		 * 정확한 값을 나중에 채워주겠다는 의미임
		 */
		
		String sql = "INSERT INTO public.t_user VALUES(?, ?,?, ?, ?, ?, now())";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/*
		 * 인파라미터 설정시 데이터 타입에 맞게 set메서드를 사용함
		 * set메서드는 데이터 타입별로 다양하게 준비되어 있음
		 */
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPwd());
		pstmt.setString(3, user.getNama());
		pstmt.setString(4, user.getEmail());
		pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
		pstmt.setString(6, user.getSns());
		
		int rowCnt = pstmt.executeUpdate();
		
		return rowCnt;
	}

	private void deleteAll() throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "delete from t_user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}
	
	//@Test
	public void selectUserTest() throws SQLException {
		deleteAll();
		User user = new User("earth", "0629", "earth", "earth@gmail.com", new Date() , "fb", new Date());
		int rowCnt = insertUser(user);
		User user2 = selectUser("earth");
		
		assertTrue(user2.getId().equals("earth"));
	}

	
	private User selectUser(String id) throws SQLException {
		Connection conn = ds.getConnection();
		
		String sql = "select * from t_user where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setId(rs.getString(1));
			user.setPwd(rs.getString(2));
			user.setNama(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setBirth(new Date(rs.getDate(5).getTime()));
			user.setSns(rs.getString(6));
			user.setReg_date(new Date(rs.getDate(7).getTime()));
			
			return user;
		}
		return null;
	}
	
	//@Test
	public void deleteUserTest() throws SQLException {
		deleteAll();
		
		int rowCont = deleteUser("earth");
		assertTrue(rowCont == 0);
		
		User user = new User("earth", "0629", "earth", "earth@gmail.com", new Date() , "fb", new Date());
		
		rowCont = insertUser(user);
		assertTrue(rowCont == 1);
		
		rowCont = deleteUser(user.getId());
		assertTrue(selectUser(user.getId()) == null);
	}

	private int deleteUser(String id) throws SQLException {
		Connection conn = ds.getConnection();
		
		String sql = "delete from t_user where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
//		int rowCont = pstmt.executeUpdate();
//		return rowCont;
		
		return pstmt.executeUpdate();
	}
	
	
	@Test
	public void UpdateUserTest() throws SQLException {
		deleteAll();	//1. 일단 다 삭제 -> 아무것도 없음
		
		User user = new User("earth8", "0629", "earth", "earth@gmail.com", new Date() , "fb", new Date());	
		
		int rowCnt = insertUser(user);	
		assertTrue(rowCnt == 1);  //테이블 안에 유저가 한명이 있다
		
		user.setPwd("0630");
		user.setNama("earth4");
		user.setEmail("earth9@gamil.com");  //변경할 내용
		
		updateUser(user); //메서드 사용 
		assertTrue(rowCnt == 1);
		 
	}


	private int updateUser(User user) throws SQLException {
		//데이터베이스 연결
		Connection conn = ds.getConnection();
		
		//쿼리문 작성
		String sql = "update  t_user "
				+ "set  pwd =?, name = ?, email = ?, birth = ?, sns =?, reg_date = ? "
				+ "where  id = ?";
		
		//쿼리문 객체 생성 (Statement, PreparedStatement)
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//?에 대한 세팅
		pstmt.setString(1, user.getPwd());
		pstmt.setString(2, user.getNama());
		pstmt.setString(3, user.getEmail());
		pstmt.setDate(4,new java.sql.Date(user.getBirth().getTime()));
		pstmt.setString(5, user.getSns());
		pstmt.setDate(6, new java.sql.Date(user.getReg_date().getTime()));
		pstmt.setString(7, user.getId());
		int rowCnt = pstmt.executeUpdate();
		
		return rowCnt;
		
		
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
  
package com.earth.work;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class TransactionTest {

	@Autowired
	DataSource ds;
	
	@Test
	public void transcationTest() throws SQLException {
		Connection conn = null;
		
		try {
			deleteAll();
			conn = ds.getConnection();
			conn.setAutoCommit(true);		//기본값은 conn.setAutoCommit(true)
			
			String sql = "INSERT INTO t_user VALUES (?,?,?,?,?,?,now())";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "earth1");
			pstmt.setString(2, "0629");
			pstmt.setString(3, "earth1");
			pstmt.setString(4, "earth1@gmail.com");
			pstmt.setDate(5, new Date(new java.util.Date().getTime()));
			pstmt.setString(6, "fb");
			
			int rowCnt = pstmt.executeUpdate();		//insert 실행함 
			
			pstmt.setString(1, "earth1");
			rowCnt = pstmt.executeUpdate();					//insert 실행함
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn.rollback();
		} finally {
			
		}

		
	}

	private void deleteAll() throws SQLException {
		Connection conn  = ds.getConnection();
		String sql = "delete from t_user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		
	}
}















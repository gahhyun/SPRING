package com.earth.work.service;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earth.work.service.A1Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class A1DaoTest {

	@Autowired
	A1Dao a1Dao;
	
	@Autowired
	DataSource ds;
	
	@Test
	public void insertTest() {
		a1Dao.insert(1, 100);
		a1Dao.insert(2, 200);
		
//		a1Dao.insert(1, 100);	//성공
//		a1Dao.insert(1, 200);	//실패
	}
	
}
















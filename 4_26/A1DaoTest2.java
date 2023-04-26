package com.earth.work;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.earth.work.service.A1Dao2;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class A1DaoTest2 {

	@Autowired
	A1Dao2 a1Dao;
	
	@Autowired
	DataSource ds;
	
	@Test
	public void insertTest() {
//		a1Dao.insert(1, 100);
//		a1Dao.insert(2, 200);
		
//		a1Dao.insert(1, 100);	//성공
//		a1Dao.insert(1, 200);	//실패
		
		//TxManager를 생성
		PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
		
		//Tx 시작
		TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
		
		try {
			a1Dao.deleteAll();
			a1Dao.insert(1, 100);
			a1Dao.insert(2, 200);		
			tm.commit(status);			//Tx 끝 = 성공하고 커밋
		}catch (Exception e) {
			tm.rollback(status);		//Tx 끝 = 실패하고 롤백
		
	}
	

	}
}















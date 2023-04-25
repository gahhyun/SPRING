package com.earth.work;

import java.sql.SQLException;

//인터페이스로 파일만 대체하면 됨
public interface UserDao {

	User selectUser(String id);
	int deleteUser(String id);
	void deleteAll() throws SQLException;
	int updateUser(User user);
	int insertUser(User user);
	
}

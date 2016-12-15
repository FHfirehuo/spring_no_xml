package com.eiecc.fire.spring_4_no_xml.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eiecc.fire.spring_4_no_xml.dao.UserDao;

@Repository
public class JDBCUserDao implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(String string) {
		try {
			String sql = "insert into test(name) values (?)";
			
			jdbcTemplate.update(sql, string);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package com.votingSystem.repository;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int revokeAuthority(int subAdminId) throws SerialException, IOException, SQLException  {
		
		
		String query = "UPDATE users " +
	               "SET is_authority_revoked = CASE " +
	               "WHEN is_authority_revoked = 0 THEN 1 " +
	               "ELSE 0 " +
	               "END " +
	               "WHERE user_id = ?";

//		String query = "UPDATE users SET is_authority_revoked = not is_authority_revoked where user_id = ?";

	   int result =	jdbcTemplate.update(query,subAdminId);


		return result;
	}

}

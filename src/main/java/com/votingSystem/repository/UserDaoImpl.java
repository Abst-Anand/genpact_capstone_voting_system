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
	   int result =	jdbcTemplate.update(query,subAdminId);


		return result;
	}

	@Override
	public int isApproved(int voterId) throws SerialException, IOException, SQLException  {
		
		
		String query = "UPDATE users " +
	               "SET is_approved = CASE " +
	               "WHEN is_approved = 0 THEN 1 " +
	               "ELSE 0 " +
	               "END " +
	               "WHERE user_id = ?";
	   int result =	jdbcTemplate.update(query,voterId);


		return result;
	}

}

package com.votingSystem.repository;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	public int revokeAuthority(int subAdminId) throws SerialException, IOException, SQLException;

	public int isApproved(int voterId) throws SerialException, IOException, SQLException;
	
	
}

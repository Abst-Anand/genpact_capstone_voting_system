package com.votingSystem.repository;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Repository;

@Repository
public interface User {
	
	public int revokeAuthority(int subAdminId) throws SerialException, IOException, SQLException;

}

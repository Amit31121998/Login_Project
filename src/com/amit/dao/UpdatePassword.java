package com.amit.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amit.util.ConnectionFactory;

public class UpdatePassword {
	
	public boolean updatePwd(String email,String pwd) throws SQLException, IOException
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement("update Student_Registration set Password=? where Email=?");
		pstmt.setString(1, pwd);
		pstmt.setString(2, email);
		int row = pstmt.executeUpdate();
		return row>0;
		
	}
	

}

package com.amit.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amit.dto.StudentFamilyDto;
import com.amit.util.ConnectionFactory;

public class StudentFamilyDetails {

	public boolean insertFamilyDetails(StudentFamilyDto dto) throws SQLException, IOException {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into Student_Family_Details values(?,?,?,?)");
		pstmt.setInt(1, dto.getId());
		pstmt.setString(2, dto.getFname());
		pstmt.setString(3, dto.getMname());
		pstmt.setInt(4, dto.getNoofsibling());
		int row = pstmt.executeUpdate();
		return row>0;
	}
}

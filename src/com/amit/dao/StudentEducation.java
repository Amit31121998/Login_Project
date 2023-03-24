package com.amit.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amit.dto.StudentEducationDto;
import com.amit.util.ConnectionFactory;

public class StudentEducation {

	public boolean insertEducationDetails(StudentEducationDto dto) throws SQLException, IOException
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into Student_Education values(?,?,?,?)");
		pstmt.setInt(1, dto.getId());
		pstmt.setString(2, dto.getGraduation());
		pstmt.setInt(3, dto.getPercent());
		pstmt.setInt(4, dto.getPassout());
		int row = pstmt.executeUpdate();
		return row>0;
		
		
	}
}

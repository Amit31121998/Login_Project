package com.amit.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amit.dto.StudentAddressDto;
import com.amit.util.ConnectionFactory;

public class StudentAddress {

	public boolean saveAddress(StudentAddressDto dto) throws SQLException, IOException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into Student_Address values(?,?,?,?)");
		pstmt.setInt(1,dto.getId());
		pstmt.setString(2, dto.getCity());
		pstmt.setString(3, dto.getState());
		pstmt.setString(4, dto.getCountry());
		int row = pstmt.executeUpdate();
		return row>0;
	}
}

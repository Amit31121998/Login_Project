package com.amit.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amit.dto.StudentDto;
import com.amit.util.ConnectionFactory;

public class StudentRegDao {

	public boolean insert(StudentDto dto) throws SQLException, IOException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(
				"insert into Student_Registration(Fname,Lname,Email,Password,gender) values(?,?,?,?,?)");
		pstmt.setString(1, dto.getFname());
		pstmt.setString(2, dto.getLname());
		pstmt.setString(3, dto.getEmail());
		pstmt.setString(4, dto.getPwd());
		pstmt.setString(5, dto.getGender());
		int row = pstmt.executeUpdate();
		return row > 0;
	}

	public boolean Login(String email, String pass) throws SQLException, IOException {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select Password from Student_Registration where Email=?");
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String pwd = rs.getString("Password");
			if (pwd.equals(pass)) {
				return true;
			}
		}

		return false;

	}

	public boolean ForgateValidation(String email) throws SQLException, IOException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select Email from Student_Registration where Email=?");
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String eml = rs.getString("Email");
			if (eml.equals(email))
				return true;
		}
		return false;
	}

	public boolean UpdatePwd(String pwd, String email) throws SQLException, IOException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement("update Student_Registration set Password=? where Email=?");
		pstmt.setString(1, pwd);
		pstmt.setString(2, email);
		int row = pstmt.executeUpdate();
		return row > 0;
	}

	public int getId(String email) throws SQLException, IOException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select Id from Student_Registration where Email=? ");
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("Id");
			return id;
		}
		return 0;

	}

}

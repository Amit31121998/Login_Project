package com.amit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amit.dao.StudentRegDao;
import com.amit.dto.StudentDto;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");

		StudentDto sdto = new StudentDto();
		sdto.setFname(fname);
		sdto.setLname(lname);
		sdto.setEmail(email);
		sdto.setPwd(pwd);
		sdto.setGender(gender);

		StudentRegDao dao = new StudentRegDao();
		try {
			boolean status = dao.insert(sdto);
			if(status)
			{
			   request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

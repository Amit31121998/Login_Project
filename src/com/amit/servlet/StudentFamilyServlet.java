package com.amit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amit.dao.StudentFamilyDetails;
import com.amit.dao.StudentRegDao;
import com.amit.dto.StudentFamilyDto;

@WebServlet("/StudentFamilyServlet")
public class StudentFamilyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String mname = request.getParameter("mname");
		int sib = Integer.parseInt(request.getParameter("sibling"));

		HttpSession session = request.getSession();
		String s = (String) session.getAttribute("email");

		StudentRegDao sdao = new StudentRegDao();
		try {
			int id = sdao.getId(s);
			StudentFamilyDto dto = new StudentFamilyDto();
			dto.setFname(fname);
			dto.setMname(mname);
			dto.setNoofsibling(sib);
			dto.setId(id);

			StudentFamilyDetails sd = new StudentFamilyDetails();
			boolean status = sd.insertFamilyDetails(dto);
			if (status) {
				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

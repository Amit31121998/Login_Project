package com.amit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amit.dao.StudentRegDao;

@WebServlet("/forgatServlet")
public class forgatServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		StudentRegDao dao = new StudentRegDao();
		try {
			boolean status = dao.ForgateValidation(email);
			if (status) {

				HttpSession session = request.getSession();
				session.setAttribute("email", email);

				request.getRequestDispatcher("/enterpwd.jsp").forward(request, response);

			} else {
				String msg = "invalid email";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/forgat.jsp").include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package com.amit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amit.dao.UpdatePassword;

@WebServlet("/UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pwd = request.getParameter("pwd");

		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");

		UpdatePassword up = new UpdatePassword();
		try {
			boolean status = up.updatePwd(email, pwd);
			if(status)
			{
				session.invalidate();
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

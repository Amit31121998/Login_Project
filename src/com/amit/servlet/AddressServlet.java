package com.amit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amit.dao.StudentAddress;
import com.amit.dao.StudentRegDao;
import com.amit.dto.StudentAddressDto;

@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");

		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("email");

		StudentRegDao sdao = new StudentRegDao();
		try {
			int id = sdao.getId(s);
			StudentAddressDto dto = new StudentAddressDto();
			dto.setCity(city);
			dto.setState(state);
			dto.setCountry(country);
			dto.setId(id);

			StudentAddress sd = new StudentAddress();
			boolean status = sd.saveAddress(dto);
			if (status) {
				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

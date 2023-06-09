package com.amit.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amit.dao.StudentEducation;
import com.amit.dao.StudentRegDao;
import com.amit.dto.StudentEducationDto;

@WebServlet("/EducationServlet")
public class EducationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String graduation = request.getParameter("gradu");
		int percentage = Integer.parseInt(request.getParameter("percent"));
		int passout = Integer.parseInt(request.getParameter("passout"));

		
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("email");

		StudentRegDao sdao = new StudentRegDao();
		try {
			int id = sdao.getId(s);
			StudentEducationDto dto = new StudentEducationDto();
			dto.setGraduation(graduation);
			dto.setPercent(percentage);
			dto.setPassout(passout);
            dto.setId(id);
            
            StudentEducation se=new StudentEducation();
            boolean status = se.insertEducationDetails(dto);
            if(status)
            {
            	request.getRequestDispatcher("/dashboard.jsp").forward(request, response);	
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

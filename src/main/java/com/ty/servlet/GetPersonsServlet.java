package com.ty.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.PersonDao;
import com.ty.dto.Person;

@WebServlet("/displayperson")
public class GetPersonsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PersonDao personDao = new PersonDao();
		List<Person> persons = personDao.getAllPersons();
		
		req.setAttribute("myPerson", persons);
		RequestDispatcher dispatcher = req.getRequestDispatcher("displayperson.jsp");
		dispatcher.forward(req, resp);
	}
}


package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.PersonDao;
import com.ty.dto.Person;

@WebServlet("/createperson")
public class CreatePersonServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Person person = new Person();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		
		person.setName(name);
		person.setEmail(email);
		person.setPhone(Long.parseLong(phone));
		person.setAge(Integer.parseInt(age));
		person.setGender(gender);
		
		PersonDao personDao = new PersonDao();
		personDao.addPerson(person);
		
		PrintWriter pw =resp.getWriter();
		pw.print("<html><body><h1>Person Created</h1></body></html>");
	
	}
}

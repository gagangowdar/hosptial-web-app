package com.ty.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.EncounterDao;
import com.ty.dto.Encounter;


@WebServlet("/displayencounter")
public class DisplayEncountersServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EncounterDao dao = new EncounterDao();
		String personid = req.getParameter("personid");
		int personId = Integer.parseInt(personid);
		List<Encounter> encounters = dao.getEncountersByPersonId(personId);

		System.out.println("display encounter Servlet is called");

		req.setAttribute("encounterList",encounters);

		RequestDispatcher dispatcher = req.getRequestDispatcher("display_encounter.jsp");
		dispatcher.forward(req, resp);
	}
}

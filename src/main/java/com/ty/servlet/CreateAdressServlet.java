package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.AdressDao;
import com.ty.dto.Adress;



@WebServlet("/createadress")
public class CreateAdressServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		int branchId = Integer.parseInt(req.getParameter("branchid"));
		String state=req.getParameter("state");
		Integer pin=Integer.parseInt(req.getParameter("pin"));
		String adress = req.getParameter("adress");


		Adress adress2 = new Adress();
		adress2.setAdress(adress);
		adress2.setState(state);
		adress2.setPin(pin);

		AdressDao dao = new AdressDao();
		dao.addAddres(branchId, adress2);

		PrintWriter printWriter=resp.getWriter();
		printWriter.print("<html><body><h1>order created</h1></body></html>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("create_adress.jsp");
		dispatcher.include(req, resp);
	}
}

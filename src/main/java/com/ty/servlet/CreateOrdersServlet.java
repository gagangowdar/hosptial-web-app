package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.OrderDao;
import com.ty.dto.Orders;

@WebServlet("/createorder")
public class CreateOrdersServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		String name=(String)httpSession.getAttribute("name");
		String reason=req.getParameter("message");

		String dateTime = req.getParameter("DateTime");
		LocalDateTime dateTimee = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
		int encounterId = Integer.parseInt(req.getParameter("encounterId"));
		Orders orders = new Orders();
		orders.setMessage(reason);
		orders.setDateTime(dateTimee);
		orders.setCreaterName(name);


		OrderDao dao = new OrderDao();
		dao.saveOrder(encounterId, orders);

		PrintWriter printWriter=resp.getWriter();
		printWriter.print("<html><body><h1>order created</h1></body></html>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("create_orders.jsp");
		dispatcher.include(req, resp);
	}
}
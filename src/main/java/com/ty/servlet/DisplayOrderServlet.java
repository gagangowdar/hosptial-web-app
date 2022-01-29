package com.ty.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.OrderDao;
import com.ty.dto.Orders;

@WebServlet("/getallorders")
public class DisplayOrderServlet extends HttpServlet{

	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session=req.getSession();
    	int encounterId=Integer.parseInt(req.getParameter("encounterId"));
    	OrderDao dao=new OrderDao();
    	List<Orders> list=dao.getOrdersList(Integer.parseInt(req.getParameter("encounterId")));
    	session.setAttribute("orders", list);
    	RequestDispatcher dispatcher=req.getRequestDispatcher("display_orders.jsp");
    	dispatcher.forward(req, resp);
    	
    
	
	
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		HttpSession session=req.getSession();
//    	int encounterId=Integer.parseInt(req.getParameter("encounterId"));
//    	OrderDao dao=new OrderDao();
//    	List<Orders> list=dao.getOrdersList(Integer.parseInt(req.getParameter("encounterId")));
//    	session.setAttribute("orders", list);
//    	RequestDispatcher dispatcher=req.getRequestDispatcher("view_orders.jsp");
//    	dispatcher.forward(req, resp);
		
		
//		OrderDao dao = new OrderDao();
//		List<Orders> orders = dao.getAllOrder();
//
//		System.out.println("display order Servlet is called");
//
//		req.setAttribute("orderList",orders);
//
//		RequestDispatcher dispatcher = req.getRequestDispatcher("display_orders.jsp");
//		dispatcher.forward(req, resp);
	}
}
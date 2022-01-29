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

import com.ty.dao.ItemDao;
import com.ty.dto.Items;

@WebServlet("/getallItems")
public class DisplayItemServlet extends HttpServlet{
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	ItemDao dao=new ItemDao();
	 	   List<Items> list=dao.getItemList(Integer.parseInt(req.getParameter("orderId")));
	    	HttpSession session=req.getSession();
	    	session.setAttribute("orders",  list);
	    	RequestDispatcher dispatcher=req.getRequestDispatcher("display_item.jsp");
	    	dispatcher.forward(req, resp);
	    
	 }
	

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		ItemDao dao = new ItemDao();
//		List<Items> items = dao.getAllItem();
//
//		System.out.println("display item Servlet is called");
//
//		req.setAttribute("itemList",items);
//
//		RequestDispatcher dispatcher = req.getRequestDispatcher("display_item.jsp");
//		dispatcher.forward(req, resp);
//	}
	
}

package com.ty.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.ItemDao;
import com.ty.dto.Items;


@WebServlet("/createitem")
public class CreateItemServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		Integer branchId =(Integer)httpSession.getAttribute("id");
		String name = (String) httpSession.getAttribute("name");
		String message = req.getParameter("message");
		Integer price=Integer.parseInt(req.getParameter("price"));
		Integer quantity=Integer.parseInt(req.getParameter("quantity"));

		Items items = new Items();
		items.setName(name);
		items.setMessage(message);
		items.setPrice(price);
		items.setQuantity(quantity);

		int orderId = Integer.parseInt(req.getParameter("orderid"));

		ItemDao itemDao = new ItemDao();
		itemDao.saveItem(orderId, items);

	}
}
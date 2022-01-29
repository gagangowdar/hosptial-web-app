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

import com.ty.dao.AdressDao;
import com.ty.dto.Adress;



@WebServlet("/displayadress")
public class DisplayAdressServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
    	AdressDao dao=new AdressDao();
    	List<Adress> adresses=dao.getAdressList(Integer.parseInt(req.getParameter("branchId")));
    	session.setAttribute("adresses", adresses);
    	RequestDispatcher dispatcher=req.getRequestDispatcher("display_adress.jsp");
    	dispatcher.forward(req, resp);
	}
}

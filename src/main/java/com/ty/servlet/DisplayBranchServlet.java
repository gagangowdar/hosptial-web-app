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

import com.ty.dao.BranchDao;
import com.ty.dto.Branch;


@WebServlet("/getallbranches")
public class DisplayBranchServlet extends HttpServlet{
	
	
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	HttpSession session=req.getSession();
	 	BranchDao branchDao=new BranchDao();
	 	session.setAttribute("branches", branchDao.getBranchList(Integer.parseInt(req.getParameter("hospitalId"))));
	 	RequestDispatcher dispatcher=req.getRequestDispatcher("display_branch.jsp");
	 	dispatcher.forward(req, resp);
	 }

}	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		BranchDao dao = new BranchDao();
//		List<Branch> branchs = dao.getAllBranch();
//
//		System.out.println("display branch Servlet is called");
//
//		req.setAttribute("branchList",branchs);
//
//		RequestDispatcher dispatcher = req.getRequestDispatcher("display_branch.jsp");
//		dispatcher.forward(req, resp);
//	}


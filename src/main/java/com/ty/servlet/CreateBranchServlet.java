package com.ty.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.BranchDao;
import com.ty.dto.Branch;



@WebServlet("/createbranch")
public class CreateBranchServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		Integer adressId =(Integer)httpSession.getAttribute("adressid");
		String name = (String) httpSession.getAttribute("name");
		String email = req.getParameter("email");
		Integer phone=Integer.parseInt(req.getParameter("phone"));
		
		Branch branch = new Branch();
		branch.setEmail(email);
		branch.setName(name);
		branch.setPhone(phone);
		
		int hospitalId = Integer.parseInt(req.getParameter("hospitalid"));
		
		BranchDao branchDao = new BranchDao();
		branchDao.creatBranch(hospitalId,branch);
		
	}
}

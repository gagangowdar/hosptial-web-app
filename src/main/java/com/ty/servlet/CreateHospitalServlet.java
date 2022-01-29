package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.HospitalDao;
import com.ty.dto.Hospital;

@WebServlet("/createhospital")
public class CreateHospitalServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Hospital hospital = new Hospital();
		String name = req.getParameter("name");
		String website = req.getParameter("website");
		String gst = req.getParameter("gst");
		
		hospital.setName(name);
		hospital.setWebsite(website);
		hospital.setGst(gst);
		
		HospitalDao hospitalDao = new HospitalDao();
		hospitalDao.createHospital(hospital);
		
		PrintWriter pw =resp.getWriter();
		pw.print("<html><body><h1>Hospital Created</h1></body></html>");
		
	}
}

package com.tbs01.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tbs01.dao.BusDao;
import com.tbs01.pojo.Amount;
import com.tbs01.pojo.Bus;
import com.tbs01.pojo.User;

@WebServlet("/BusServlet")
public class BusServlet extends HttpServlet {
	
	Bus bus = new Bus();
	BusDao bsd = new BusDao();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		
	
		String action = req.getParameter("action");
		if(action!=null && action.equals("delete")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			boolean b = bsd.deleteBus(id);
			if(b) {
				resp.sendRedirect("BusServlet");
			}
			
		}else if(action!=null && action.equals("edit")){
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			Bus i = bsd.getBus(id);
			
			session.setAttribute("inc", i);
			
			resp.sendRedirect("updateincome.jsp"); //
			
		}
		else if(action!=null && action.equals("searchByIncType")) {
			String type = req.getParameter("type");
			
			//List<Bus> inclist = bsd.getBusListByType(user.getId(), type);
			List<Bus> inclist = bsd.getBusListByType(user.getId(), type);
		
			
			session.setAttribute("inclist", inclist);
			resp.sendRedirect("busdetailslist.jsp");
			
		}
		
		
		else {
			
		List<Bus> inclist = bsd.getBusList();
			
		//int id = Integer.parseInt(req.getParameter("id"));
		//List<Bus> inclist = bsd.getBusList(id);  // not used user_id
			
		session.setAttribute("inclist", inclist);
		resp.sendRedirect("busdetailslist.jsp");
		
	}
		
	
	}
		
		
		
	
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		String action = req.getParameter("action");
		
		User user =(User)session.getAttribute("user");
		
		/*String amountType = req.getParameter("amountType");
		String description = req.getParameter("description");
		
		amt.setAmount_type(amountType);
		
		amt.setDescription(description);*/
		
	/*	if(action!=null && action.equals("addIncome")) {
			
			double amount = Double.parseDouble(req.getParameter("income"));
			bus.setBus_number(action);
			int userid = Integer.parseInt(req.getParameter("userId"));
			
			
			
			boolean b = amtd.addamount(amt);
			if(b) {
				resp.sendRedirect("index.jsp");
			}else {
				resp.sendRedirect("addamount.jsp");
			}
			
			} */
		/*	else if(action!=null && action.equals("updateIncome")) {
				
				double amount = Double.parseDouble(req.getParameter("income"));
				amt.setAmount(amount);
				int userid = Integer.parseInt(req.getParameter("userId"));
				amt.setUser_id(userid);
				
				int id = Integer.parseInt(req.getParameter("id"));
				amt.setId(id);
				
				boolean b = amtd.updateAmount(amt);
				
				if(b) {
					resp.sendRedirect("IncomeServlet");
				}
			} */
			 if(action!=null && action.equals("srch")) {
				String search = req.getParameter("search");
				
				//List<Amount> inclist = amtd.getAmountListByDescription(user.getId(), search);
				
				int id = Integer.parseInt(req.getParameter("id"));
				List<Bus> inclist = bsd.getBusListByDescription(id, search);
				session.setAttribute("inclist", inclist);
				resp.sendRedirect("amountlist.jsp");
				
			}
	} 
		
	}



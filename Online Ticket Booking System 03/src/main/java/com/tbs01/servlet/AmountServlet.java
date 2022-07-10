package com.tbs01.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tbs01.dao.AmountDao;
import com.tbs01.pojo.Amount;
import com.tbs01.pojo.User;



@WebServlet("/AmountServlet")
public class AmountServlet extends HttpServlet {
		
	
	
	
		Amount amt = new Amount();
		AmountDao amtd = new AmountDao();
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			User user = (User)session.getAttribute("user");
			
			String action = req.getParameter("action");
			if(action!=null && action.equals("delete")) {
				
				int id = Integer.parseInt(req.getParameter("id"));
				
				boolean b = amtd.deleteamount(id);
				if(b) {
					resp.sendRedirect("AmountServlet");
				}
				
			}else if(action!=null && action.equals("edit")){
				
				int id = Integer.parseInt(req.getParameter("id"));
				
				Amount i = amtd.getAmount(id);
				
				session.setAttribute("inc", i);
				
				resp.sendRedirect("updateincome.jsp"); //
				
			}
			else if(action!=null && action.equals("searchByIncType")) {
				String type = req.getParameter("type");
				
				List<Amount> inclist = amtd.getAmountListByType(user.getId(), type);
				session.setAttribute("uid", user.getId());
				session.setAttribute("inclist", inclist);
				resp.sendRedirect("amountlist.jsp");
				
			}
			
			
			else {
				
			List<Amount> inclist = amtd.getAmountList(user.getId());
			session.setAttribute("inclist", inclist);
			resp.sendRedirect("amountlist.jsp");
			
		}
		}
		
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			

			HttpSession session = req.getSession();
			
			String action = req.getParameter("action");
			
			User user =(User)session.getAttribute("user");
			
			String amountType = req.getParameter("amountType");
			String description = req.getParameter("description");
			
			amt.setAmount_type(amountType);
			
			amt.setDescription(description);
			
			if(action!=null && action.equals("addIncome")) {
				
				double amount = Double.parseDouble(req.getParameter("income"));
				amt.setAmount(amount);
				int userid = Integer.parseInt(req.getParameter("userId"));
				amt.setUser_id(userid);
				
				
				boolean b = amtd.addamount(amt);
				if(b) {
					resp.sendRedirect("index.jsp");
				}else {
					resp.sendRedirect("addamount.jsp");
				}
				
				}
				else if(action!=null && action.equals("updateIncome")) {
					
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
				}
				else if(action!=null && action.equals("srch")) {
					String search = req.getParameter("search");
					
					List<Amount> inclist = amtd.getAmountListByDescription(user.getId(), search);
					session.setAttribute("inclist", inclist);
					resp.sendRedirect("amountlist.jsp");
					
				}
		}
}

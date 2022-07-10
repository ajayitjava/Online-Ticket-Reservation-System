package com.tbs01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.tbs01.dao.TicketDao;
import com.tbs01.pojo.Ticket;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	
		
		Ticket tic = new Ticket();
		TicketDao ticd = new TicketDao();
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			
			List<Ticket> tick = ticd.getBookingList();
			session.setAttribute("tick", tick);
			resp.sendRedirect("bookinglist.jsp");
			
		}
		
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
				String action = req.getParameter("action");
				
				
				if(action !=null && action.equals("addIncome")) {
				
				int userid = Integer.parseInt(req.getParameter("userId"));
				int busid  = Integer.parseInt(req.getParameter("busid"));
				String source = req.getParameter(req.getParameter("source"));
				String destination = req.getParameter(req.getParameter("destination"));
				double fare = Double.parseDouble(req.getParameter("fare"));
				double payamount = Double.parseDouble(req.getParameter("pay"));
				
				
				tic.setUserid(userid);
				tic.setBusid(busid);
				tic.setSource(source);
				tic.setDestination(destination);
				tic.setFare(fare);
				tic.setPayamount(payamount);
				
				boolean b = ticd.addTicket(tic);
				
				if(b) {
					resp.sendRedirect("index.jsp");
				}
				else {
					resp.sendRedirect("bookticket.jsp");
				}
		}
		}			
}

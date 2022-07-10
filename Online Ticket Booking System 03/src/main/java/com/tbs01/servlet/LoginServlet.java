package com.tbs01.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tbs01.dao.UserDao;
import com.tbs01.pojo.User;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
		User u = new User();
		UserDao ud = new UserDao();
	
	 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 		HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect("index.jsp");
	 	}
	 	
	 	
	 	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 		HttpSession session = req.getSession();
			String email = req.getParameter("email");
			String passw = req.getParameter("passw");
			u = ud.userLogin(email, passw);
			if(u!=null && email!=null && u.getEmail().equals(email) && u.getPassword().equals(passw)) {
				session.setAttribute("user", u);
				//session.setAttribute("bal", incd.getBalance(u.getId()));
				resp.sendRedirect("index.jsp");
			}
			else {
				req.setAttribute("lmsg", "UserName and Password incorrect...");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);
			}
			
			
		}
	 	
}

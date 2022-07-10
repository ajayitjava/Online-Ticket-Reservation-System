package com.tbs01.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import com.mysql.cj.Session;
import com.tbs01.dao.UserDao;
import com.tbs01.pojo.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	User u = new User();
	UserDao ud = new UserDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		
		String email = req.getParameter("email");
		String password1 = req.getParameter("passw1");
		String password2 = req.getParameter("passw2");
		
		String action = req.getParameter("action");
		if(action!=null && action.equals("adduser")) {

		if (email != null && password1.equals(password2)) {

			boolean b = ud.adduser(email, password2);
			
		   
			
			if (b) {
				resp.sendRedirect("index.jsp");
			} else {
				req.setAttribute("lmsg", "User Name Already Exists...");
				RequestDispatcher rd = req.getRequestDispatcher("adduser.jsp");
				rd.include(req, resp);
			}
		} else {
			req.setAttribute("lmsg", "Password and Confirmed Password not Matched...");
			RequestDispatcher rd = req.getRequestDispatcher("adduser.jsp");
			rd.include(req, resp);

		}
		}
		else if(action!=null && action.equals("updateuser")) {
			
			HttpSession session = req.getSession();
			
			String name = req.getParameter("name");
			String contact = req.getParameter("contact");
			
			String address = req.getParameter("address");  //
			int age = Integer.parseInt(req.getParameter("age"));				//
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			u.setContact(contact);
			u.setEmail(email);
			u.setName(name);
			u.setAddress(address);
			u.setAge(age);
			u.setId(id);
			u.setPassword(password1);
			
			boolean b = ud.updateUser(u);
			if(b) {
				session.setAttribute("user", u); // update session
				resp.sendRedirect("index.jsp");
			}
		
		}
	}

}

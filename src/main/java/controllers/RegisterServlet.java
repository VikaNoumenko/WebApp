package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import model.DAO;
import model.impl.DAOimplHibernate;

@WebServlet("/registrate")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAOimplHibernate();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		
		
		HashMap<String, String> info = new HashMap<String, String>();
		
		info.put("userName", request.getParameter("userName"));
		info.put("password", request.getParameter("password"));
	
		
		dao.createUser(info);
		
		session.setAttribute("pageStatus", " You are registered!");
		response.getWriter().println(" You are registered! ");
//		response.sendRedirect("/Mail");
	}
}

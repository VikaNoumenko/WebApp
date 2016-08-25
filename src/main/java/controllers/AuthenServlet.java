package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import model.DAO;
import model.impl.DAOimplHibernate;

@WebServlet("/login")
public class AuthenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAOimplHibernate();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HttpSession session = request.getSession(true);
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (login(userName, password)) {
//			session.setAttribute("userInfo", dao.getUserInfo(userName));
//			session.setAttribute("messages", dao.getUserMessages(userName));
//			session.setAttribute("usersList", dao.getUsersList());
//			response.sendRedirect("/Mail/main.jsp");
			response.getWriter().println(" You are Welcome! ");
//		} else {
//			
//			session.setAttribute("pageStatus", "Wrong userName!");
//			response.sendRedirect("/Mail");
//		}
		}
	}


	private boolean login(String name, String pass) {
		String passFromDB = dao.getPassword(name);

		if(pass.equals(passFromDB)) {
			return true;
		} else {
			return false;
		}
	}
}

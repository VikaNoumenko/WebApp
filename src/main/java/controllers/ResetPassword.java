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

@WebServlet("/forgot")
public class ResetPassword extends HttpServlet {

	private static final long serialVersionUID = 1L;
	DAO dao = new DAOimplHibernate();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		if (dao.resetPassword(userName, password)) {
			
		session.setAttribute("pageStatus", " Password is changed! ");
		response.getWriter().println(" Password is changed! ");
//			response.sendRedirect("/Mail");
//		} else {
//			session.setAttribute("pageStatus", "Wrong userName! ");
//			response.sendRedirect("/Mail/forgot.jsp");
//		}
		}
	}
	}

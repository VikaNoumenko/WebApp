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


@WebServlet("/send")
public class MessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		DAO dao = new DAOimplHibernate();
		
		String userName = (String) session.getAttribute("userName");
		String receiver = request.getParameter("receiver");
		String messageText = request.getParameter("text");
		
		if(dao.setMessage(userName, receiver, messageText)) {
			session.setAttribute("pageStatus", "Message to user " + receiver + " is sent!");
			response.sendRedirect("/Mail/main.jsp#send");
		} else {
			session.setAttribute("pageStatus", " Could not send the message!");
			response.sendRedirect("/Mail/main.jsp#send");
		}
		
	}

}

package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
import dao.DaoException;
import metier.forms.*;

/**
 * Servlet implementation class Authentification
 */
@WebServlet({ "/login", "/logout" })
public class Auth extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;
	private static final String	LOGIN_VIEW			= "/WEB-INF/login.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String requestedUrl = request.getServletPath();

		if (requestedUrl.equals("/login"))
		{
			getServletContext().getRequestDispatcher(LOGIN_VIEW).forward(request, response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		
		AuthForm authForm = new AuthForm(request);
		Admin admin= new Admin();
		try {
			admin = authForm.connect();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (admin != null)
		{
			
			response.sendRedirect(request.getContextPath() + "/users/all");
		}
		else
		{
			request.setAttribute("authForm", authForm);
			getServletContext().getRequestDispatcher(LOGIN_VIEW).forward(request, response);
		}
	}

}

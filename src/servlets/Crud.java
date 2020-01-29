package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;
import dao.*;
import metier.forms.*;

/**
 * Servlet implementation beans classes
 */
@WebServlet("/users/*")
public class Crud extends HttpServlet
{
	private static final long				serialVersionUID	= 1L;
	
	private static final String				ADD_CLIENT_VIEW		= "/WEB-INF/crud/add-client.jsp";
	private static final String				UPDATE_CLIENT_VIEW	= "/WEB-INF/crud/update-client.jsp";
	private static final String				CLIENTS_LIST_VIEW	= "/WEB-INF/clients.jsp";
	
	private static final String				ADD_PRODUCT_VIEW	= "/WEB-INF/crud/add-product.jsp";
	private static final String				PRODUCTS_LIST_VIEW	= "/WEB-INF/crud/products.jsp";

	public static final List<Client>		clients				= new ArrayList<Client>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String requestedUrl = request.getRequestURI();
		if (requestedUrl.endsWith("/users/add"))
		{
			getServletContext().getRequestDispatcher(ADD_CLIENT_VIEW).forward(request, response);
		}
		else if (requestedUrl.endsWith("/users/all"))
		{
			try {
				request.setAttribute("clientsList", ClientDao.getList());
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher(CLIENTS_LIST_VIEW).forward(request, response);
		}
		else if (requestedUrl.endsWith("/users/update"))
		{
			String login = request.getParameter("login");
			Client client = null;
			try {
				client= ClientDao.getClientByLogin(login);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("client", client);
			getServletContext().getRequestDispatcher(UPDATE_CLIENT_VIEW).forward(request, response);
		
		}
		else if (requestedUrl.endsWith("/users/delete"))
		{
			String login = request.getParameter("login");
			try {
				ClientDao.delete(login);
				request.setAttribute("clientsList", ClientDao.getList());
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("clientDeleted", login);
			getServletContext().getRequestDispatcher(CLIENTS_LIST_VIEW).forward(request, response);
		}
		else
		{
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
		request.setCharacterEncoding("utf-8");
		String requestedUrl = request.getRequestURI();
		
		
		if (requestedUrl.endsWith("/users/add"))
		{
			AddClientForm addClientform= new AddClientForm(request);
			Client client = addClientform.getClient();

			if (addClientform.isValid())
			{
				try {
					ClientDao.add(client);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			request.setAttribute("client", client);
			request.setAttribute("passwordsErrors", addClientform.getMessageErreurs());
			request.setAttribute("statusMessage", addClientform.getStatusMessage());

			getServletContext().getRequestDispatcher(ADD_CLIENT_VIEW).forward(request, response);
		}
		else {
			if (requestedUrl.endsWith("/users/update"))
			{
				UpdateClientForm updateClientform= new UpdateClientForm(request);
				Client client = updateClientform.getClient();
				
				if (updateClientform.isValid())
				{
					try {
						ClientDao.update(client);
					} catch (DaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				request.setAttribute("clientUpdated", client);
				//request.setAttribute("passwordsErrors", addClientform.getMessageErreurs());
				//request.setAttribute("statusMessage", addClientform.getStatusMessage());

				getServletContext().getRequestDispatcher(UPDATE_CLIENT_VIEW).forward(request, response);
			}
		}
	}

	public static List<Client> getClients()
	{
		return clients;
	}
}

package metier.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.*;
import dao.AdminDao;
import dao.DaoException;
import servlets.*;

public class AuthForm
{
	private static final String	LOGIN_FIELD		= "AuthLogin";
	private static final String	PASSWORD_FIELD	= "AuthPassword";
	private HttpServletRequest	request;
	private String				login;

	public AuthForm(HttpServletRequest request)
	{
		this.request = request;
	}

	public Admin connect() throws DaoException
	{
		login = getParamater(LOGIN_FIELD);
		String password = getParamater(PASSWORD_FIELD);

		List<Admin> admins = AdminDao.getList();
		for (Admin admin : admins)
		{
			if (admin.getLogin().equals(login)
					&& admin.getPassword().equals(password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("administrator", admin);
				return admin;
			}
		}
		return null;
	}

	private String getParamater(String parametre)
	{
		String valeur = request.getParameter(parametre);
		valeur = valeur == null || valeur.trim().isEmpty() ? null
				: valeur.trim();
		return valeur;
	}

	public String getLogin()
	{
		return login;
	}
}

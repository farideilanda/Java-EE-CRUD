package metier.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.*;

public class AddClientForm
{
	private static final String	LASTNAME_FIELD		= "FormLastname";
	private static final String	FIRSTNAME_FIELD		= "FormFirstname";
	private static final String	LOGIN_FIELD			= "FormLogin";
	private static final String	PASSWORD_FIELD		= "FormPassword";
	private static final String	PASSWORD_BIS_FIELD	= "FormPasswordBis";

	private HttpServletRequest	request;
	private Client				client;
	private String				statusMessage;
	private Map<String, String>	messageErreurs		= new HashMap<String, String>();

	public AddClientForm(HttpServletRequest request)
	{
		this.request = request;

		String login = getParamater(LOGIN_FIELD);
		String password = getParamater(PASSWORD_FIELD);
		String firstname = getParamater(FIRSTNAME_FIELD);
		String lastname = getParamater(LASTNAME_FIELD);

		client = new Client(login, password, firstname, lastname);
		
		
		validerPasswords();
		
		if (messageErreurs.isEmpty())
		{
			statusMessage = "1";
		}
		else
		{
			statusMessage = "0";
		}
	}

	
	private String getParamater(String param)
	{
		String valeur = request.getParameter(param);
		valeur = valeur == null || valeur.trim().isEmpty() ? null
				: valeur.trim();
		return valeur;
	}

	private void validerPasswords()
	{
		String password = getParamater(PASSWORD_FIELD);
		String passwordBis = getParamater(PASSWORD_BIS_FIELD);
		if (password != null && !password.equals(passwordBis))
		{
			messageErreurs.put(PASSWORD_FIELD,
					"Les mots de passe ne sont pas conformes");
			messageErreurs.put(PASSWORD_BIS_FIELD,
					"Les mots de passe ne sont pas conformes");
		}
	}

	public Client getClient()
	{
		return client;
	}

	public String getStatusMessage()
	{
		return statusMessage;
	}

	public Map<String, String> getMessageErreurs()
	{
		return messageErreurs;
	}

	public boolean isValid()
	{
		return messageErreurs.isEmpty();
	}

}

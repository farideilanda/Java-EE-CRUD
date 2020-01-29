package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.*;

public class ClientDao
{
	private static final String	ADD_CLIENT_SQL	= "INSERT INTO clients VALUES(?, ?, ?, ?)";
	private static final String	GET_CLIENT_BY_LOGIN_SQL	= "SELECT * FROM clients WHERE login LIKE ?";
	private static final String	UPDATE_CLIENT_SQL	= "UPDATE clients SET password= ?, firstname= ?, lastname= ? WHERE login LIKE ?";
	private static final String	DELETE_CLIENT_SQL	= "DELETE FROM clients WHERE login LIKE ?";
	private static final String	SELECT_CLIENTS_SQL	= "SELECT * FROM clients";

	public static void add(Client client) throws DaoException
	{
		Connection connexion = DBManager.getConnection();
		try
		{
			PreparedStatement statement = connexion.prepareStatement(ADD_CLIENT_SQL);
			statement.setString(1, client.getLogin());
			statement.setString(2, client.getPassword());
			statement.setString(3, client.getFirstname());
			statement.setString(4, client.getLastname());
			statement.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new DaoException("Client non ajouté");
		}
	}
	
	public static void update(Client c) throws DaoException
	{
		Connection connexion = DBManager.getConnection();
		try
		{
			PreparedStatement statement = connexion.prepareStatement(UPDATE_CLIENT_SQL);
			statement.setString(1, c.getPassword());
			statement.setString(2, c.getFirstname());
			statement.setString(3, c.getLastname());
			statement.setString(4, c.getLogin());
			statement.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new DaoException("Client non mis à jour");
		}
	}
	
	public static void delete(String l) throws DaoException
	{
		Connection connexion = DBManager.getConnection();
		try
		{
			PreparedStatement statement = connexion.prepareStatement(DELETE_CLIENT_SQL);
			statement.setString(1, l);
			statement.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new DaoException("Client supprimé");
		}
	}
	
	public static Client getClientByLogin(String l) throws DaoException
	{
		Connection connexion = DBManager.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String gfirstname= "", glastname="", gpassword="";
		try
		{
			statement = connexion.prepareStatement(GET_CLIENT_BY_LOGIN_SQL);
			statement.setString(1, l);
			resultSet = statement.executeQuery();
			
			while (resultSet.next())
			{
				gpassword = resultSet.getString(2);
				gfirstname = resultSet.getString(3);
				glastname = resultSet.getString(4);
			}
			
			return new Client(l, gpassword, gfirstname, glastname);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<Client> getList() throws DaoException
	{
		Connection connexion = DBManager.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Client> clients = null;
		try
		{
			int id;
			clients = new ArrayList<Client>();
			String firstname, lastname, login, password;
			statement = connexion.createStatement();
			resultSet = statement.executeQuery(SELECT_CLIENTS_SQL);
			while (resultSet.next())
			{
				// id = resultSet.getInt(1);
				login = resultSet.getString(1);
				password = resultSet.getString(2);
				firstname = resultSet.getString(3);
				lastname = resultSet.getString(4);
				clients.add(new Client(login, password, firstname, lastname));
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}
}

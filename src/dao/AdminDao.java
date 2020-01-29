package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.*;

public class AdminDao
{
	private static final String	ADD_ADMIN_SQL	= "INSERT INTO admin VALUES(?, ?)";
	private static final String	SELECT_ADMINS_SQL	= "SELECT * FROM admin";

	public static void add(Admin admin) throws DaoException
	{
		Connection connexion = DBManager.getConnection();
		try
		{
			PreparedStatement statement = connexion.prepareStatement(ADD_ADMIN_SQL);
			statement.setString(1, admin.getLogin());
			statement.setString(2, admin.getPassword());
			statement.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new DaoException("Admin non ajouté");
		}
	}

	public static List<Admin> getList() throws DaoException
	{
		Connection connexion = DBManager.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Admin> admins = null;
		try
		{
			//int id;
			admins = new ArrayList<Admin>();
			String login, password;
			statement = connexion.createStatement();
			resultSet = statement.executeQuery(SELECT_ADMINS_SQL);
			while (resultSet.next())
			{
				// id = resultSet.getInt(1);
				login = resultSet.getString(1);
				password = resultSet.getString(2);
				admins.add(new Admin(login, password));
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admins;
	}
}

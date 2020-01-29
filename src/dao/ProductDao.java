package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.*;

public class ProductDao
{
	private static final String	ADD_PRODUCT_SQL	= "INSERT INTO products VALUES(?, ?, ?)";
	private static final String	SELECT_PRODUCT_SQL	= "SELECT * FROM products WHERE client LIKE ?";

	public static void add(Product product) throws DaoException
	{
		Connection connexion = DBManager.getConnection();
		try
		{
			PreparedStatement statement = connexion.prepareStatement(ADD_PRODUCT_SQL);
			statement.setString(1, product.getDesignation());
			statement.setString(2, product.getQuantity());
			statement.setString(3, product.getClient());
			statement.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new DaoException("Produit non ajouté");
		}
	}

	public static List<Product> getList(String client) throws DaoException
	{
		Connection connexion = DBManager.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Product> produits = null;
		try
		{
			int id;
			produits = new ArrayList<Product>();
			String designation, quantity;
			statement = connexion.prepareStatement(SELECT_PRODUCT_SQL);
			statement.setString(1, client);
			resultSet = statement.executeQuery();
			
			while (resultSet.next())
			{
				// id = resultSet.getInt(1);
				designation = resultSet.getString(2);
				quantity = resultSet.getString(3);
				produits.add(new Product(designation, quantity, client));
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}
}

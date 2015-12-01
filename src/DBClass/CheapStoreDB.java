package DBClass;





import java.awt.Image;
import java.sql.Blob;

///////////////////////////////////////////////

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;

import model.Item;
import model.UserAccount;

/**
 * A class that consists of the database operations to insert and update the Movie information.
 * @author mmuppa
 *
 */

public class CheapStoreDB {
	private static String userName = "_445team9"; //Change to yours
	private static String password = "yicKamna";
	private static String serverName = "cssgate.insttech.washington.edu";//"localhost"; //IF using CSSGATE SERVER ->  "cssgate.insttech.washington.edu";
	private static Connection conn;
	private List<UserAccount> list;
	private List<Item> itemsList;
	

	/**
	 * Creates a sql connection to MySQL using the properties for
	 * userid, password and server information.
	 * @throws SQLException
	 */
	public static void createConnection() throws SQLException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);

		conn = DriverManager.getConnection("jdbc:" + "mysql" + "://"
				+ serverName + "/", connectionProps);

		System.out.println("Connected to database");
	}

	/**
	 * Returns a list of movie objects from the database.
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<UserAccount> getUsers() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select usersEmail, usersImage, typeOfAccount, name, address, password "
				+ "from _445team9.Account ";

		list = new ArrayList<UserAccount>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String usersEmail = rs.getString("usersEmail");
				Image usersImage = (Image) rs.getBlob("usersImage");
				String typeOfAccount = rs.getString("typeOfAccount");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String password = rs.getString("password");
				
				UserAccount user = new UserAccount(usersEmail, usersImage, typeOfAccount, name, address, password);
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return list;
	}

	
	
	
	/**
	 * Returns a list of movie objects from the database.
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Item> getItems() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select date, description, image, inStock, itemId, name, price "
				+ "from CheapStoreDB.Item ";

		itemsList = new ArrayList<Item>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String date = rs.getString("date");
				String description = rs.getString("description");
				
				Blob blob = rs.getBlob("image");
				ImageIcon imageIcon = new ImageIcon(
				 blob.getBytes(1, (int)blob.length()));
				
				ImageIcon image = imageIcon; //(Image) rs.getBlob("image");
				int inStock = rs.getInt("inStock");
				int itemId = rs.getInt("itemId");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				
				
				Item item = new Item(itemId, name, description, image, date, price, inStock );
				itemsList.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return itemsList;
	}
	
	
	
	
	/**
	 * Filters the movie list to find the given title. Returns a list with the
	 * movie objects that match the title provided.
	 * @param title
	 * @return list of movies that contain the title.
	 */
//	public List<UserAccount> getMovies(String title) {
//		List<UserAccount> filterList = new ArrayList<UserAccount>();
//		try {
//			list = getMovies();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		for (UserAccount movie : list) {
//			if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
//				filterList.add(movie);
//			}
//		}
//		return filterList;
//	}

	/**
	 * Adds a new movie to the table.
	 * @param movie 
	 */
//	public void addMovie(UserAccount movie) {
//		String sql = "insert into moviedb.Movies values " + "(?, ?, ?, ?, ?, null); ";
//
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = conn.prepareStatement(sql);
//			preparedStatement.setString(1, movie.getTitle());
//			preparedStatement.setInt(2, movie.getYear());
//			preparedStatement.setInt(3, movie.getLength());
//			preparedStatement.setString(4, movie.getGenre());
//			preparedStatement.setString(5, movie.getStudioName());
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println(e);
//			e.printStackTrace();
//		} 
//	}

	/**
	 * Modifies the movie information corresponding to the index in the list.
	 * @param row index of the element in the list
	 * @param columnName attribute to modify
	 * @param data value to supply
	 */
//	public void updateMovie(int row, String columnName, Object data) {
//		
//		UserAccount movie = list.get(row);
//		String title = movie.getTitle();
//		int year = movie.getYear();
//		String sql = "update moviedb.Movies set " + columnName + " = ?  where title= ? and year = ? ";
//		System.out.println(sql);
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = conn.prepareStatement(sql);
//			if (data instanceof String)
//				preparedStatement.setString(1, (String) data);
//			else if (data instanceof Integer)
//				preparedStatement.setInt(1, (Integer) data);
//			preparedStatement.setString(2, title);
//			preparedStatement.setInt(3, year);
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println(e);
//			e.printStackTrace();
//		} 
//		
//	}
}

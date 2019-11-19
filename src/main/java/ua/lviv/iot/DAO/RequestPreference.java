package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.Preference;

public class RequestPreference {
	    private static final String SELECT_ALL = "SELECT * FROM preference";
	    private static final String INSERT = "INSERT preference (id_user, id_post, date) VALUES (?, ?, ?)";
	    private static final String DELETE = "DELETE FROM preference WHERE id_user=? AND id_post=?";
	    private static final String UPDATE = "UPDATE preference SET id_user=?, id_post=?, date=? WHERE id_user=? AND id_post=?";
	    
	    
	    public static String insert (Preference preference) throws SQLException {
	    	String update = "запит(INSERT) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
	             ps.setInt(1,preference.getUserId());
	             ps.setInt(2,preference.getPostId());
	             ps.setString(3,preference.getDate());
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    
	    public static ArrayList<Preference> findAll() throws SQLException {
	 	   Connection connection = ConnectionManager.getConnection();
	 	   ArrayList<Preference> list = new ArrayList<Preference>();
		   try (Statement statement = connection.createStatement()) {
			    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
		           while (resultSet.next()) {
		        	   Preference preference = new Preference();
		        	   preference.setUserId(resultSet.getInt(1));
		        	   preference.setPostId(resultSet.getInt(2));
		        	   preference.setDate(resultSet.getString(3));
		        	   list.add(preference);
		           }	       
		   } catch (SQLException e) {
	           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
	       }
		   return list;
		}
	    
	    public static String update(Preference preference, int userId, int postId) throws SQLException {
	    	String update = "запит(UPDATE) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
	             ps.setInt(1,preference.getUserId());
	             ps.setInt(2,preference.getPostId());
	             ps.setString(3,preference.getDate());
	             ps.setInt(4, userId);
	             ps.setInt(5, postId);
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(UPDATE) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    public static String delete(int userId, int postId) throws SQLException {
	    	String delete = "запит(DELETE) пройшов успішно";
	        Connection conn = ConnectionManager.getConnection();
	        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
	            ps.setInt(1, userId);
	            ps.setInt(2, postId);
	            ps.executeUpdate();
	        }catch (SQLException e) {
	            System.out.println("Сталася помилка під час запиту(DELETE) до бази даних: \n" + e);
	        }
	        return delete;
	    }
	}
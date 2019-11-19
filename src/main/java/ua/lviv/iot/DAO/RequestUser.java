package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.User;

public class RequestUser {
	    private static final String SELECT_ALL = "SELECT * FROM user";
	    private static final String INSERT = "INSERT user (id_user, nick_name, foto, last_activity) VALUES (?, ?, ?, ?)";
	    private static final String DELETE = "DELETE FROM user WHERE id_user=?";
	    private static final String UPDATE = "UPDATE user SET id_user=?, nick_name=?, foto=?, last_activity=?   WHERE id_user=?";
	    
	    
	    public static String insert (User user) throws SQLException {
	    	String update = "запит(INSERT) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
	             ps.setInt(1,user.getUserId());
	             ps.setString(2,user.getNickName());
	             ps.setString(3,user.getFoto());
	             ps.setString(4,user.getLastActivity());
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    
	    public static ArrayList<User> findAll() throws SQLException {
	 	   Connection connection = ConnectionManager.getConnection();
	 	   ArrayList<User> list = new ArrayList<User>();
		   try (Statement statement = connection.createStatement()) {
			    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
		           while (resultSet.next()) {
		        	   User user = new User();
		        	   user.setUserId(resultSet.getInt(1));
		        	   user.setNickName(resultSet.getString(2));
		        	   user.setFoto(resultSet.getString(3));
		        	   user.setLastActivity(resultSet.getString(4));
		        	   list.add(user);
		           }	       
		   } catch (SQLException e) {
	           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
	       }
		   return list;
		}
	    
	    public static String update(User user, int userId) throws SQLException {
	    	String update = "запит(UPDATE) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
	             ps.setInt(1,user.getUserId());
	             ps.setString(2,user.getNickName());
	             ps.setString(3,user.getFoto());
	             ps.setString(4,user.getLastActivity());
	             ps.setInt(5, userId);
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(UPDATE) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    public static String delete(int userId) throws SQLException {
	    	String delete = "запит(DELETE) пройшов успішно";
	        Connection conn = ConnectionManager.getConnection();
	        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
	            ps.setInt(1, userId);
	            ps.executeUpdate();
	        }catch (SQLException e) {
	            System.out.println("Сталася помилка під час запиту(DELETE) до бази даних: \n" + e);
	        }
	        return delete;
	    }
	}
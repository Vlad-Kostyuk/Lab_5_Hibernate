package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.TypePost;

public class RequestTypePost {
	    private static final String SELECT_ALL = "SELECT * FROM type_post";
	    private static final String INSERT = "INSERT type_post (id_type_post, type) VALUES (?, ?)";
	    private static final String DELETE = "DELETE FROM type_post WHERE id_type_post=?";
	    private static final String UPDATE = "UPDATE type_post SET id_type_post=?, type=? WHERE id_type_post=?";
	    
	    
	    public static String insert (TypePost typePost) throws SQLException {
	    	String update = "запит(INSERT) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
	             ps.setInt(1,typePost.getTypePostId());
	             ps.setString(2,typePost.getType());
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    
	    public static ArrayList<TypePost> findAll() throws SQLException {
	 	   Connection connection = ConnectionManager.getConnection();
	 	   ArrayList<TypePost> list = new ArrayList<TypePost>();
		   try (Statement statement = connection.createStatement()) {
			    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
		           while (resultSet.next()) {
		        	   TypePost typePost = new TypePost();
		        	   typePost.setTypePostId(resultSet.getInt(1));
		        	   typePost.setType(resultSet.getString(2));
		        	   list.add(typePost);
		           }	       
		   } catch (SQLException e) {
	           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
	       }
		   return list;
		}
	    
	    public static String update(TypePost typePost, int typePostId) throws SQLException {
	    	String update = "запит(UPDATE) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
	             ps.setInt(1,typePost.getTypePostId());
	             ps.setString(2,typePost.getType());
	             ps.setInt(3, typePostId);
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(UPDATE) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    public static String delete(int typePostId) throws SQLException {
	    	String delete = "запит(DELETE) пройшов успішно";
	        Connection conn = ConnectionManager.getConnection();
	        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
	            ps.setInt(1, typePostId);
	            ps.executeUpdate();
	        }catch (SQLException e) {
	            System.out.println("Сталася помилка під час запиту(DELETE) до бази даних: \n" + e);
	        }
	        return delete;
	    }
	}



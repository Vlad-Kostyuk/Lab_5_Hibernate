package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.Post;

public class RequestPost {
	 private static final String SELECT_ALL = "SELECT * FROM post";
	    private static final String INSERT = "INSERT post(id_post, id_user, id_type_post, date, description) VALUES (?, ?, ?, ?, ?)";
	    private static final String DELETE = "DELETE FROM post WHERE id_post=?";
	    private static final String UPDATE = "UPDATE post SET id_post=?, id_user=?, id_type_post=?, date=?, description=?  WHERE id_post=?";
	    
	    public static String insert (Post post) throws SQLException {
	    	String update = "запит(INSERT) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
	             ps.setInt(1,post.getPostId());
	             ps.setInt(2,post.getUserId());
	             ps.setInt(3,post.getTypePostId());
	             ps.setInt(4,post.getDate());
	             ps.setString(5,post.getDescription());
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    public static ArrayList<Post> findAll() throws SQLException {	
	 	   Connection connection = ConnectionManager.getConnection();
	 	   ArrayList<Post> list = new ArrayList<Post>();
		   try (Statement statement = connection.createStatement()) {
			    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
		           while (resultSet.next()) {
		        	   Post post = new Post();
		        	   post.setPostId(resultSet.getInt(1));
		        	   post.setUserId(resultSet.getInt(2));
		        	   post.setTypePostId(resultSet.getInt(3));
		        	   post.setDate(resultSet.getInt(4));
		        	   post.setDescription(resultSet.getString(5));
		        	   list.add(post);
		           }	       
		   } catch (SQLException e) {
	           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
	       }
		   return list;
		}
	    
	    public static String update(Post post, int idPost) throws SQLException {
	    	String update = "запит(UPDATE) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
	    		 ps.setInt(1,post.getPostId());
	             ps.setInt(2,post.getUserId());
	             ps.setInt(3,post.getTypePostId());
	             ps.setInt(4,post.getDate());
	             ps.setString(5,post.getDescription());
	             ps.setInt(6,idPost);
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(UPDATE) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    public static String delete(int idPost) throws SQLException {
	    	String delete = "запит(DELETE) пройшов успішно";
	        Connection conn = ConnectionManager.getConnection();
	        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
	            ps.setInt(1,idPost);
	            ps.executeUpdate();
	        }catch (SQLException e) {
	            System.out.println("Сталася помилка під час запиту(DELETE) до бази даних: \n" + e);
	        }
	        return delete;
	    }
	}
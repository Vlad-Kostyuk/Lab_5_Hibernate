package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.PreferenceComment;

public class RequestPreferenceComment {
	    private static final String SELECT_ALL = "SELECT * FROM preference_comment";
	    private static final String INSERT = "INSERT preference_comment (id_comment, id_user) VALUES (?, ?)";
	    private static final String DELETE = "DELETE FROM preference_comment WHERE id_comment=?";
	    private static final String UPDATE = "UPDATE preference_comment SET id_comment=?, id_user=? WHERE id_comment=?";
	    
	    
	    public static String insert (PreferenceComment preferenceComment) throws SQLException {
	    	String update = "запит(INSERT) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
	             ps.setInt(1,preferenceComment.getCommentId());
	             ps.setInt(2,preferenceComment.getUserId());
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    
	    public static ArrayList<PreferenceComment> findAll() throws SQLException {
	 	   Connection connection = ConnectionManager.getConnection();
	 	   ArrayList<PreferenceComment> list = new ArrayList<PreferenceComment>();
		   try (Statement statement = connection.createStatement()) {
			    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
		           while (resultSet.next()) {
		        	   PreferenceComment preferenceComment = new PreferenceComment();
		        	   preferenceComment.setCommentId(resultSet.getInt(1));
		        	   preferenceComment.setUserId(resultSet.getInt(2));
		        	   list.add(preferenceComment);
		           }	       
		   } catch (SQLException e) {
	           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
	       }
		   return list;
		}
	    
	    public static String update(PreferenceComment preferenceComment, int commentId) throws SQLException {
	    	String update = "запит(UPDATE) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
	             ps.setInt(1,preferenceComment.getCommentId());
	             ps.setInt(2,preferenceComment.getUserId());
	             ps.setInt(3, commentId);
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(UPDATE) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    public static String delete(int commentId) throws SQLException {
	    	String delete = "запит(DELETE) пройшов успішно";
	        Connection conn = ConnectionManager.getConnection();
	        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
	            ps.setInt(1, commentId);
	            ps.executeUpdate();
	        }catch (SQLException e) {
	            System.out.println("Сталася помилка під час запиту(DELETE) до бази даних: \n" + e);
	        }
	        return delete;
	    }
	    
	}
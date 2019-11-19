package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.Comment;


public class RequestComment {
	private static final String SELECT_ALL = "SELECT * FROM comment";
    private static final String INSERT = "INSERT comment (id_comment, id_answer, id_post, id_user, text) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM comment WHERE id_comment=?";
    private static final String UPDATE = "UPDATE comment SET id_comment=?, id_answer=?, id_post=?, id_user=?, text=? WHERE id_comment=?";
    
    public static String insert (Comment �omment) throws SQLException {
    	String update = "�����(INSERT) ������� ������";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
    		 ps.setInt(1,�omment.getCommentId());
             ps.setInt(2,�omment.getAnswerId());
             ps.setInt(3,�omment.getPostId());
             ps.setInt(4,�omment.getUserId());
             ps.setString(5,�omment.getText());
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("������� ������� �� ��� ������(INSERT) �� ���� �����: \n" + e);
        }
		return update;
    }
    
    
    public static ArrayList<Comment> findAll() throws SQLException {
 	   Connection connection = ConnectionManager.getConnection();
 	   ArrayList<Comment> list = new ArrayList<Comment>();
	   try (Statement statement = connection.createStatement()) {
		    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
	           while (resultSet.next()) {
	        	   Comment �omment = new Comment();
	        	   �omment.setCommentId(resultSet.getInt(1));
	        	   �omment.setAnswerId(resultSet.getInt(2));
	        	   �omment.setPostId(resultSet.getInt(3));
	        	   �omment.setUserId(resultSet.getInt(4));
	        	   �omment.setText(resultSet.getString(5));
	        	   list.add(�omment);
	           }	       
	   } catch (SQLException e) {
           System.out.println("������� ������� �� ��� ������(SELECT_ALL) �� ���� �����: \n" + e);
       }
	   return list;
	}
    
    public static String update(Comment �omment, int commentId) throws SQLException {
    	String update = "�����(UPDATE) ������� ������";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
             ps.setInt(1,�omment.getCommentId());
             ps.setInt(2,�omment.getAnswerId());
             ps.setInt(3,�omment.getPostId());
             ps.setInt(4,�omment.getUserId());
             ps.setString(5,�omment.getText());
             ps.setInt(6, commentId);
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("������� ������� �� ��� ������(UPDATE) �� ���� �����: \n" + e);
        }
		return update;
    }
    
    public static String delete(int commentId) throws SQLException {
    	String delete = "�����(DELETE) ������� ������";
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
        	deleteChildren(commentId);
            ps.setInt(1,commentId);
            ps.executeUpdate();
        }catch (SQLException e) {
            System.out.println("������� ������� �� ��� ������(DELETE) �� ���� �����: \n" + e);
        }
        return delete;
    }
    
    public static void deleteChildren(int commentId) throws SQLException {
      Connection conn = ConnectionManager.getConnection();
  	  String delete = "DELETE FROM preference_comment WHERE id_comment=?";
  	  try (PreparedStatement ps = conn.prepareStatement(delete)) {
	            ps.setInt(1, commentId);
	            ps.executeUpdate();
	        }catch (SQLException e) {
	            System.out.println("������� ������� �� ��� ������(DELETE Children) �� ���� �����: \n" + e);
	        }
    }
}

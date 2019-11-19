package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.Tag;

public class RequestTag {
	
	private static final String SELECT_ALL = "SELECT * FROM tag";
    private static final String INSERT = "INSERT tag (id_user, id_post, tag) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM tag WHERE id_user=? AND id_post=?";
    private static final String UPDATE = "UPDATE tag SET id_user=?, id_post=?, tag=? WHERE id_user=? AND id_post=?";
    
    
    public static String insert (Tag tag) throws SQLException {
    	String update = "�����(INSERT) ������� ������";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
             ps.setInt(1,tag.getUserId());
             ps.setInt(2,tag.getPostId());
             ps.setString(3,tag.getTag());
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("������� ������� �� ��� ������(INSERT) �� ���� �����: \n" + e);
        }
		return update;
    }
    
    
    public static ArrayList<Tag> findAll() throws SQLException {
 	   Connection connection = ConnectionManager.getConnection();
 	   ArrayList<Tag> list = new ArrayList<Tag>();
	   try (Statement statement = connection.createStatement()) {
		    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
	           while (resultSet.next()) {
	        	   Tag tag = new Tag();
	        	   tag.setUserId(resultSet.getInt(1));
	        	   tag.setPostId(resultSet.getInt(2));
	        	   tag.setTag(resultSet.getString(3));
	        	   list.add(tag);
	           }	       
	   } catch (SQLException e) {
           System.out.println("������� ������� �� ��� ������(SELECT_ALL) �� ���� �����: \n" + e);
       }
	   return list;
	}
    
    public static String update(Tag tag, int userId, int postId) throws SQLException {
    	String update = "�����(UPDATE) ������� ������";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
             ps.setInt(1,tag.getUserId());
             ps.setInt(2,tag.getPostId());
             ps.setString(3,tag.getTag());
             ps.setInt(4, userId);
             ps.setInt(5, postId);
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("������� ������� �� ��� ������(UPDATE) �� ���� �����: \n" + e);
        }
		return update;
    }
    
    public static String delete(int userId, int postId) throws SQLException {
    	String delete = "�����(DELETE) ������� ������";
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1, userId);
            ps.setInt(2, postId);
            ps.executeUpdate();
        }catch (SQLException e) {
            System.out.println("������� ������� �� ��� ������(DELETE) �� ���� �����: \n" + e);
        }
        return delete;
    }
}
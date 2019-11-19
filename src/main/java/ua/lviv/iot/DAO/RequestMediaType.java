package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.MediaType;

public class RequestMediaType {
	
    private static final String SELECT_ALL = "SELECT * FROM media_type";
    private static final String INSERT = "INSERT media_type (id_media_type, media_type) VALUES (?, ?)";
    private static final String DELETE = "DELETE FROM media_type WHERE id_media_type=?";
    private static final String UPDATE = "UPDATE media_type SET id_media_type=?, media_type=? WHERE id_media_type=?";
    
    
    public static String insert (MediaType mediaType) throws SQLException {
    	String update = "запит(INSERT) пройшов успішно";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
             ps.setInt(1,mediaType.getMediaTypeId());
             ps.setString(2,mediaType.getMediaType());
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
        }
		return update;
    }
    
    public static ArrayList<MediaType> findAll() throws SQLException {	
 	   Connection connection = ConnectionManager.getConnection();
 	   ArrayList<MediaType> list = new ArrayList<MediaType>();
	   try (Statement statement = connection.createStatement()) {
		    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
	           while (resultSet.next()) {
	        	   MediaType mediaType = new MediaType();
	        	   mediaType.setMediaTypeId(resultSet.getInt(1));
	        	   mediaType.setMediaType(resultSet.getString(2));
	        	   list.add(mediaType);
	           }	       
	   } catch (SQLException e) {
           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
       }
	   return list;
	}
    
    public static String update(MediaType mediaType, int mediaTypeId) throws SQLException {
    	String update = "запит(UPDATE) пройшов успішно";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
             ps.setInt(1,mediaType.getMediaTypeId());
             ps.setString(2,mediaType.getMediaType());
             ps.setInt(3, mediaTypeId);
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("Сталася помилка під час запиту(UPDATE) до бази даних: \n" + e);
        }
		return update;
    }
    
    public static String delete(int mediaTypeId) throws SQLException {
    	String delete = "запит(DELETE) пройшов успішно";
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
        	deleteChildren(mediaTypeId);
            ps.setInt(1, mediaTypeId);
            ps.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Сталася помилка під час запиту(DELETE) до бази даних: \n" + e);
        }
        return delete;
    }
    
    public static void deleteChildren(int mediaTypeId) throws SQLException {
  	  Connection conn = ConnectionManager.getConnection();
  	  String delete = "DELETE FROM foto_and_video WHERE id_media_type=?";
  	  try (PreparedStatement ps = conn.prepareStatement(delete)) {
	            ps.setInt(1, mediaTypeId);
	            ps.executeUpdate();
	        }catch (SQLException e) {
	            System.out.println("Сталася помилка під час запиту(DELETE Children) до бази даних: \n" + e);
	        }
    }
}
package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.FotoAndVideo;

public class RequestFotoAndVideo {

	 private static final String SELECT_ALL = "SELECT * FROM foto_and_video";
	    private static final String INSERT = "INSERT foto_and_video (id_foto_or_video, id_post, id_media_type, format, url) VALUES (?, ?, ?, ?, ?)";
	    private static final String DELETE = "DELETE FROM foto_and_video WHERE id_foto_or_video=?";
	    private static final String UPDATE = "UPDATE foto_and_video SET id_foto_or_video=?, id_post=?, id_media_type=?, format=?, url=?  WHERE id_foto_or_video=?";
	    
	    
	    public static String insert (FotoAndVideo fotoAndVideo) throws SQLException {
	    	String update = "запит(INSERT) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
	             ps.setInt(1,fotoAndVideo.getIdFotoOrVideo());
	             ps.setInt(2,fotoAndVideo.getPostId());
	             ps.setInt(3,fotoAndVideo.getMediaTypeId());
	             ps.setString(4,fotoAndVideo.getFormat());
	             ps.setString(5,fotoAndVideo.getUrl());
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    
	    public static ArrayList<FotoAndVideo> findAll() throws SQLException { 	
	 	   Connection connection = ConnectionManager.getConnection();
	 	   ArrayList<FotoAndVideo> list = new ArrayList<FotoAndVideo>();
	 	   
		   try (Statement statement = connection.createStatement()) {
			    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
		           while (resultSet.next()) {
		        	   FotoAndVideo fotoAndVideo = new FotoAndVideo();
		        	   fotoAndVideo.setIdFotoOrVideo(resultSet.getInt(1));
		        	   fotoAndVideo.setPostId(resultSet.getInt(2));
		        	   fotoAndVideo.setMediaTypeId(resultSet.getInt(3));
		        	   fotoAndVideo.setFormat(resultSet.getString(4));
		        	   fotoAndVideo.setUrl(resultSet.getString(5));
		        	   list.add(fotoAndVideo);
		           }	       
		   } catch (SQLException e) {
	           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
	       }
		   return list;
		}
	    
	    public static String update(FotoAndVideo fotoAndVideo, int fotoOrVideoId) throws SQLException {
	    	String update = "запит(UPDATE) пройшов успішно";
	    	Connection connection = ConnectionManager.getConnection();
	    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
	             ps.setInt(1,fotoAndVideo.getIdFotoOrVideo());
	             ps.setInt(2,fotoAndVideo.getPostId());
	             ps.setInt(3,fotoAndVideo.getMediaTypeId());
	             ps.setString(4,fotoAndVideo.getFormat());
	             ps.setString(5,fotoAndVideo.getUrl());
	             ps.setInt(6, fotoOrVideoId);
	             ps.executeUpdate();
	    	} catch (SQLException e) {
	        System.out.println("Сталася помилка під час запиту(UPDATE) до бази даних: \n" + e);
	        }
			return update;
	    }
	    
	    public static String delete(int fotoOrVideoId) throws SQLException {
	    	String delete = "запит(DELETE) пройшов успішно";
	        Connection conn = ConnectionManager.getConnection();
	        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
	            ps.setInt(1, fotoOrVideoId);
	            ps.executeUpdate();
	        }catch (SQLException e) {
	            System.out.println("Сталася помилка під час запиту(DELETE) до бази даних: \n" + e);
	        }
	        return delete;
	    }
	}
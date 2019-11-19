package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.UserLog;

public class RequestUserLog {
	private static final String SELECT_ALL = "SELECT * FROM user_log";
    private static final String INSERT = "INSERT user_log (user_id, date_event, log) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM user_log WHERE user_id=?";
    private static final String UPDATE = "UPDATE user_log SET user_id=?, date_event=?, log=? WHERE user_id=?";
    
    
    public static String insert (UserLog userLog) throws SQLException {
    	String update = "запит(INSERT) пройшов успішно";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
             ps.setInt(1,userLog.getUserId());
             ps.setString(2, userLog.getDateEvent());
             ps.setString(3,userLog.getLog());
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
        }
		return update;
    }
    
    
    public static ArrayList<UserLog> findAll() throws SQLException {
 	   Connection connection = ConnectionManager.getConnection();
 	   ArrayList<UserLog> list = new ArrayList<UserLog>();
	   try (Statement statement = connection.createStatement()) {
		    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
	           while (resultSet.next()) {
	        	   UserLog userLog = new UserLog();
	        	   userLog.setUserId(resultSet.getInt(1));
	        	   userLog.setDateEvent(resultSet.getString(2));
	        	   userLog.setLog(resultSet.getString(3));
	        	   list.add(userLog);
	           }	       
	   } catch (SQLException e) {
           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
       }
	   return list;
	}
    
    public static String update(UserLog userLog, int userId) throws SQLException {
    	String update = "запит(UPDATE) пройшов успішно";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
             ps.setInt(1,userLog.getUserId());
             ps.setString(2,userLog.getDateEvent());
             ps.setString(3,userLog.getLog());
             ps.setInt(4, userId);

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
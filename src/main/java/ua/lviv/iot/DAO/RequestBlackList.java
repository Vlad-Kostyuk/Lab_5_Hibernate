package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.BlackList;

public class RequestBlackList {
	
    private static final String SELECT_ALL = "SELECT * FROM blackList";
    private static final String INSERT = "INSERT blackList (user_id, locking_user_id, locking_time) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM blackList WHERE user_id=? AND locking_user_id=?";
    private static final String UPDATE = "UPDATE blackList SET user_id=?, locking_user_id=?, locking_time=? WHERE user_id=? AND locking_user_id=?";
    
    
    public static String insert (BlackList blackList) throws SQLException {
    	String update = "запит(INSERT) пройшов успішно";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
             ps.setInt(1,blackList.getUserId());
             ps.setInt(2,blackList.getLockingUserId());
             ps.setString(3,blackList.getLockingTime());
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
        }
		return update;
    }
    
    
    public static ArrayList<BlackList> findAll() throws SQLException {	
 	   Connection connection = ConnectionManager.getConnection();
 	   ArrayList<BlackList> list = new ArrayList<BlackList>();
	   try (Statement statement = connection.createStatement()) {
		    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
	           while (resultSet.next()) {
	        	   BlackList blackList = new BlackList();
	        	   blackList.setUserId(resultSet.getInt(1));
	        	   blackList.setLockingUserId(resultSet.getInt(2));
	        	   blackList.setLockingTime(resultSet.getString(3));
	        	   list.add(blackList);
	           }	       
	   } catch (SQLException e) {
           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
       }
	   return list;
	}
    
    public static String update(BlackList blackList, int userId, int lockingUserId) throws SQLException {
    	String update = "запит(UPDATE) пройшов успішно";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
             ps.setInt(1,blackList.getUserId());
             ps.setInt(2,blackList.getLockingUserId());
             ps.setString(3,blackList.getLockingTime());
             ps.setInt(4, userId);
             ps.setInt(5, lockingUserId);
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("Сталася помилка під час запиту(UPDATE) до бази даних: \n" + e);
        }
		return update;
    }
    
    public static String delete(int userId, int lockingUserId) throws SQLException {
    	String delete = "запит(DELETE) пройшов успішно";
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1, userId);
            ps.setInt(2, lockingUserId);
            ps.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Сталася помилка під час запиту(DELETE) до бази даних: \n" + e);
        }
        return delete;
    }
}
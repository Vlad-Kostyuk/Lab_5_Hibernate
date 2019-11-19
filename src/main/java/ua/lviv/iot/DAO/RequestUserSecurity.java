package ua.lviv.iot.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ua.lviv.iot.connection.ConnectionManager;
import ua.lviv.iot.model.UserSecurity;

public class RequestUserSecurity {

	private static final String SELECT_ALL = "SELECT * FROM user_security";
    private static final String INSERT = "INSERT user_security (id_user, password, phone) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM user_security WHERE id_user=?";
    private static final String UPDATE = "UPDATE user_security SET id_user=?, password=?, phone=? WHERE id_user=?";
    
    
    public static String insert(UserSecurity userSecurity) throws SQLException {
    	String update = "запит(INSERT) пройшов успішно";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(INSERT)) {
             ps.setInt(1,userSecurity.getUserId());
             ps.setString(2,userSecurity.getPassword());
             ps.setString(3,userSecurity.getPhone());
             ps.executeUpdate();
    	} catch (SQLException e) {
        System.out.println("Сталася помилка під час запиту(INSERT) до бази даних: \n" + e);
        }
		return update;
    }
    
    
    public static ArrayList<UserSecurity> findAll() throws SQLException {
 	   Connection connection = ConnectionManager.getConnection();
 	   ArrayList<UserSecurity> list = new ArrayList<UserSecurity>();
	   try (Statement statement = connection.createStatement()) {
		    ResultSet resultSet = statement.executeQuery(SELECT_ALL);
	           while (resultSet.next()) {
	        	   UserSecurity userSecurity = new UserSecurity();
	        	   userSecurity.setUserId(resultSet.getInt(1));
	        	   userSecurity.setPassword(resultSet.getString(2));
	        	   userSecurity.setPhone(resultSet.getString(3));
	        	   list.add(userSecurity);
	           }	       
	   } catch (SQLException e) {
           System.out.println("Сталася помилка під час запиту(SELECT_ALL) до бази даних: \n" + e);
       }
	   return list;
	}
    
    public static String update(UserSecurity userSecurity, int userId) throws SQLException {
    	String update = "запит(UPDATE) пройшов успішно";
    	Connection connection = ConnectionManager.getConnection();
    	try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
             ps.setInt(1,userSecurity.getUserId());
             ps.setString(2,userSecurity.getPassword());
             ps.setString(3,userSecurity.getPhone());
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
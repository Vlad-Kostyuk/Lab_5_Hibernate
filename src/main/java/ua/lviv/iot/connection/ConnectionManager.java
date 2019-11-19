package ua.lviv.iot.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/kostyuk_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "vlad771200";
	
    public static Connection getConnection() {
       Connection connection = null;   
        
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
            if(!connection.isClosed()) {
            	System.out.println("Зєднання з базою становлено");
            }
            
            if(connection.isClosed()) {
            	System.out.println("З'єднання з базою закрито");
            }
            
        } catch (SQLException e) {
            System.out.println("Сталася помилка під час підключення до бази даних: \n" + e);
        }
		return connection;
   }
 }
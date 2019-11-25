package ua.lviv.iot;

import java.sql.SQLException;

import ua.lviv.iot.connection.ConnectionManager;


public class App {

  public static void main(String[] args) throws SQLException {
	// View.showInfo();
      ConnectionManager.getSessionFactory();
      
  }
}
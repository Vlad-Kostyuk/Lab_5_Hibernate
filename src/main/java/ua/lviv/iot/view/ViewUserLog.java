package ua.lviv.iot.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import ua.lviv.iot.DAO.RequestUserLog;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.UserLog;

public class ViewUserLog {
	
	private static Controller controller  = new Controller();
	
	public static void Controler() throws SQLException {
		System.out.print("\n" + "Ведіть команду: ");
	    Scanner scan = new Scanner(System.in);
	    String comand = scan.next();
			switch (comand) {
			case "select":
				selectInfo();
				Controler();
				break;
			case "insert":
				insertInfo();
				Controler();
				break;
			case "delete":
				deleteInfo();
				Controler();
				break;
			case "update":
				updateInfo();
				Controler();
				break;
			case "exit":
				View.showInfo();
				break;
			default:
				System.out.print("Команду " + comand + "не найдена. Перевірте правильність ведених даних");
				Controler();
				break;
			}
	}
	
	public static void selectInfo() throws SQLException {
	     System.out.print(controller.findAllUserLog());
	}
	
	public static void insertInfo() throws SQLException {
		 UserLog userLog = new UserLog ();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("user_id: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userLog.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("log: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userLog.setLog(scanUpdate.next());    
		 }
		 if(true) {
			 String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		     System.out.print(timeStamp);
		     userLog.setDateEvent(timeStamp);	 
			 System.out.print(controller.insertUserLog(userLog));
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			System.out.print("user_id: ");
			Scanner scan = new Scanner(System.in);
			int userId = scan.nextInt();
		    System.out.print(controller.deleteUserLog(userId));	
	}
	
	public static void updateInfo() throws SQLException {
		 UserLog userLog = new UserLog ();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("user_id: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userLog.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("log: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userLog.setLog(scanUpdate.next());    
		 }
		 if(true) {
			 String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		     System.out.print(timeStamp);
		     userLog.setDateEvent(timeStamp);	 
			 System.out.print(RequestUserLog.insert(userLog));
		 } if(true) {
			 System.out.print("\n" + "user_id: ");
			 Scanner scan = new Scanner(System.in);
			 int userId = scan.nextInt();
			 System.out.print(controller.updateUserLog(userLog,userId));	
		 }
	}
}

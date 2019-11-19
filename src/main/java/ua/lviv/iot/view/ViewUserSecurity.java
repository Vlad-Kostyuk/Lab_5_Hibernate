package ua.lviv.iot.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import ua.lviv.iot.DAO.RequestUserSecurity;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.UserSecurity;

public class ViewUserSecurity {

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
	     System.out.print(controller.findAllUserSecurity());
	}
	
	public static void insertInfo() throws SQLException {
		 UserSecurity userSecurity = new UserSecurity();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("user_id: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userSecurity.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("password: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userSecurity.setPassword(scanUpdate.next());
		 }
		 if(true) {
			 System.out.print("phone: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userSecurity.setPhone(scanUpdate.next()); 
			 System.out.print(RequestUserSecurity.insert(userSecurity));
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			System.out.print("user_id: ");
			Scanner scan = new Scanner(System.in);
			int userId = scan.nextInt();
		    System.out.print(controller.deleteUserSecurity(userId));	
	}
	
	public static void updateInfo() throws SQLException {
		UserSecurity userSecurity = new UserSecurity();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("user_id: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userSecurity.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("password: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userSecurity.setPassword(scanUpdate.next());
		 }
		 if(true) {
			 System.out.print("phone: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 userSecurity.setPhone(scanUpdate.next()); 
		 } if(true) {
			 System.out.print("user_id: ");
			 Scanner scan = new Scanner(System.in);
			 int userId = scan.nextInt();
			 System.out.print(controller.updateUserSecurity(userSecurity,userId));	
		 }
	}
}


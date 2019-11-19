package ua.lviv.iot.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import ua.lviv.iot.DAO.RequestUser;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.User;


public class ViewUser {
	
	private static Controller controller = new Controller();
	
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
	     System.out.print(controller.findAllUser());
	}
	
	public static void insertInfo() throws SQLException {
		 User user = new User();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 user.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("nick_name: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 user.setNickName(scanUpdate.next());
		 }
		 if(true) {
			 System.out.print("foto: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 user.setFoto(scanUpdate.next());
		 }
		 if(true) {
			 String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		     System.out.print(timeStamp);
		     user.setLastActivity(timeStamp);
		     System.out.print(controller.insertUser(user));
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			System.out.print("id_user: ");
			Scanner scan = new Scanner(System.in);
			int userId = scan.nextInt();
		    System.out.print(controller.deleteUser(userId));	
	}
	
	public static void updateInfo() throws SQLException {
		 User user = new User();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 user.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("nick_name: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 user.setNickName(scanUpdate.next());
		 }
		 if(true) {
			 System.out.print("foto: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 user.setFoto(scanUpdate.next());
		 }
		 if(true) {
			 String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		     System.out.print(timeStamp);
		     user.setLastActivity(timeStamp);
		     System.out.print(RequestUser.insert(user));
		 } if(true) {
			 System.out.print("id_user: ");
			 Scanner scan = new Scanner(System.in);
			 int userId = scan.nextInt();
			 System.out.print(controller.updateUser(user,userId));	
		 }
	}
}

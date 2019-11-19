package ua.lviv.iot.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.BlackList;

public class ViewBlackList {
    
	private static Controller controller = new Controller();
	
	public static void Controler() throws SQLException {
		System.out.print("\n" + "Ведіть команду: ");
	    Scanner scaner = new Scanner(System.in);
	    String comand = scaner.next();
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
	
	public static  void selectInfo() throws SQLException {
		System.out.println(controller.findAllBlackList());
	}
	
	public static void insertInfo() throws SQLException {
		BlackList blackList = new BlackList();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("User_id: ");
			 Scanner scanInsert = new Scanner(System.in);
		     blackList.setUserId(scanInsert.nextInt());
		 }
		 if(true) {
			 System.out.print("Locking_user_id: ");
			 Scanner scanInsert = new Scanner(System.in);
		     blackList.setLockingUserId(scanInsert.nextInt());
		 }
		 if(true) {
			 String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		     System.out.print(timeStamp);
		     blackList.setLockingTime(timeStamp);
		     System.out.print(controller.insertBlackList(blackList));
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			 System.out.print("User_id: ");
			 Scanner scanDelete = new Scanner(System.in);
		     int userId = scanDelete.nextInt(); 
				 if(true) {
					 System.out.print("Locking_user_id: ");
					 Scanner scanlockingUserId = new Scanner(System.in);
				     int lockingUserId = scanlockingUserId.nextInt();
				     System.out.print(controller.deleteBlackList(userId,lockingUserId));	
				 }
	}
	
	public static void updateInfo() throws SQLException {
		 BlackList blackList = new BlackList();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("User_id: ");
			 Scanner scanUpdate = new Scanner(System.in);
		     blackList.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("Locking_user_id: ");
			 Scanner scanUpdate = new Scanner(System.in);
		     blackList.setLockingUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		     blackList.setLockingTime(timeStamp);
		 }
		 if(true) {
			 System.out.print("\n" + "User_id: ");
			 Scanner scanUpdate = new Scanner(System.in);
		     int userId = scanUpdate.nextInt(); 
				 if(true) {
					 System.out.print("Locking_user_id: ");
					 Scanner scanlockingUserId = new Scanner(System.in);
				     int lockingUserId = scanlockingUserId.nextInt();
				     System.out.print(controller.updateBlackList(blackList,userId,lockingUserId));	
				 }
		 }
	}
}
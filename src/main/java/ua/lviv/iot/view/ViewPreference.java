package ua.lviv.iot.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Preference;

public class ViewPreference {

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
	     System.out.print(controller.findAllPreference());
	}
	
	public static void insertInfo() throws SQLException {
		Preference preference = new Preference();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 preference.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 preference.setPostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		     System.out.print(timeStamp);
		     preference.setDate(timeStamp);
		     System.out.print(controller.insertPreference(preference));
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
		     int userId = scanUpdate.nextInt(); 
				 if(true) {
					 System.out.print("id_post: ");
					 Scanner scan = new Scanner(System.in);
				     int postId = scanUpdate.nextInt();
				     System.out.print(controller.deletePreference(userId,postId));	
				 }
	}
	
	public static void updateInfo() throws SQLException {
		Preference preference = new Preference();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 preference.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 preference.setPostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			 preference.setDate(timeStamp);
		 }
		 if(true) {
			 System.out.print("\n" + "id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
		     int userId = scanUpdate.nextInt(); 
				 if(true) {
					 System.out.print("id_post: ");
					 Scanner scan = new Scanner(System.in);
				     int postId = scanUpdate.nextInt();
				     System.out.print(controller.updatePreference(preference,userId,postId));	
				 }
		 }
	}
}
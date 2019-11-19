package ua.lviv.iot.view;

import java.sql.SQLException;
import java.util.Scanner;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Tag;

public class ViewTag {
	
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
	     System.out.print(controller.findAllTag());
	}
	
	public static void insertInfo() throws SQLException {
		 Tag tag = new Tag();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 tag.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 tag.setPostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("tag: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 tag.setTag(scanUpdate.next());
			 System.out.print(controller.insertTag(tag));	
		 }
	}
	
	public static void deleteInfo() throws SQLException {
		 System.out.print("id_user: ");
		 Scanner scanUpdate = new Scanner(System.in);
	     int userId = scanUpdate.nextInt(); 
			 if(true) {
				 System.out.print("id_post: ");
				 Scanner scan = new Scanner(System.in);
			     int postId = scan.nextInt();
			     System.out.print(controller.deleteTag(userId,postId));	
			 }
	}
	
	public static void updateInfo() throws SQLException {
		 Tag tag = new Tag();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 tag.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 tag.setPostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("tag: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 tag.setTag(scanUpdate.next());
		 }
		 System.out.print("id_user: ");
		 Scanner scanUpdate = new Scanner(System.in);
	     int userId = scanUpdate.nextInt(); 
			 if(true) {
				 System.out.print("id_post: ");
				 Scanner scan = new Scanner(System.in);
			     int postId = scan.nextInt();
			     System.out.print(controller.updateTag(tag,userId,postId));	
			 }
	}
}




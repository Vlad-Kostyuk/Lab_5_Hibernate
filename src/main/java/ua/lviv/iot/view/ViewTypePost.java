package ua.lviv.iot.view;

import java.sql.SQLException;
import java.util.Scanner;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.TypePost;

public class ViewTypePost {
	
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
	     System.out.print(controller.findAllTypePost());
	}
	
	public static void insertInfo() throws SQLException {
		 TypePost typePost = new TypePost();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_type_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 typePost.setTypePostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("type: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 typePost.setType(scanUpdate.next());
		     System.out.print(controller.insertTypePost(typePost));
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			System.out.print("id_type_post: ");
			Scanner scan = new Scanner(System.in);
			int typePostId = scan.nextInt();
		    System.out.print(controller.deleteTypePost(typePostId));	
	}
	
	public static void updateInfo() throws SQLException {
		 TypePost typePost = new TypePost();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_type_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 typePost.setTypePostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("type: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 typePost.setType(scanUpdate.next());
		 }
		 if(true) {
			 System.out.print("id_type_post: ");
			 Scanner scan = new Scanner(System.in);
			 int typePostId = scan.nextInt();
			 System.out.print(controller.updateTypePost(typePost,typePostId));	
		 }
	}
}



package ua.lviv.iot.view;

import java.sql.SQLException;
import java.util.Scanner;
import ua.lviv.iot.DAO.RequestPost;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Post;

public class ViewPost {
	
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
	     System.out.print(controller.findAllPost());
	}
	
	public static void insertInfo() throws SQLException {
		 Post post= new Post();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanInsert = new Scanner(System.in);
			 post.setPostId(scanInsert.nextInt());
		 }
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanInsert = new Scanner(System.in);
			 post.setUserId(scanInsert.nextInt());
		 }
		 if(true) {
			 System.out.print("id_type_post: ");
			 Scanner scanInsert = new Scanner(System.in);
			 post.setTypePostId(scanInsert.nextInt());
		 }
		 if(true) {
			 System.out.print("date: ");
			 Scanner scanInsert = new Scanner(System.in);
			 post.setDate(scanInsert.nextInt());
		 }
		 if(true) {
			 System.out.print("description: ");
			 Scanner scanInsert = new Scanner(System.in);
			 post.setDescription(scanInsert.next());
		     System.out.print(controller.insertPost(post));
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			 System.out.print("id_post: ");
			 Scanner scanDelete = new Scanner(System.in);
		     int idPost = scanDelete.nextInt(); 
		     System.out.print(controller.deletePost(idPost));
	}
	
	public static void updateInfo() throws SQLException {
		Post post= new Post();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanUpdate= new Scanner(System.in);
			 post.setPostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 post.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_type_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 post.setTypePostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("date: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 post.setDate(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("description: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 post.setDescription(scanUpdate.next());
		     System.out.print(RequestPost.insert(post));
			 if(true) {
				 System.out.print("id_post: ");
				 Scanner scan = new Scanner(System.in);
			     int idPost = scan.nextInt(); 
			     System.out.print(controller.updatePost(post,idPost));
			 }
		 }
	}
}
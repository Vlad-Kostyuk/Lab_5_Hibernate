package ua.lviv.iot.view;

import java.sql.SQLException;
import java.util.Scanner;
import ua.lviv.iot.DAO.RequestComment;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.Comment;

public class ViewComment {

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
	     System.out.print(controller.findAllComment());
	}
	
	public static void insertInfo() throws SQLException {
		 Comment comment = new Comment();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_comment: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setCommentId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_answer: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setAnswerId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setPostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_text: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setText(scanUpdate.next());
		     System.out.print(controller.insertComment(comment));
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			 System.out.print("id_comment: ");
			 Scanner scanUpdate = new Scanner(System.in);
		     int idComment = scanUpdate.nextInt(); 
		     System.out.print(controller.deleteComment(idComment));	
	}
	
	public static void updateInfo() throws SQLException {
		 Comment comment = new Comment();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_comment: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setCommentId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_answer: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setAnswerId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setPostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_text: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 comment.setText(scanUpdate.next());
		     System.out.print(RequestComment.insert(comment));
		 }
		 if(true) {
			 System.out.print("id_comment: ");
			 Scanner scanUpdate = new Scanner(System.in);
		     int idComment = scanUpdate.nextInt(); 
		     System.out.print(controller.updateComment(comment,idComment));	
		 }
	}
}
package ua.lviv.iot.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import ua.lviv.iot.DAO.RequestPreference;
import ua.lviv.iot.DAO.RequestPreferenceComment;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.PreferenceComment;

public class ViewPreferenceComment {
	
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
	     System.out.print(controller.findAllPreferenceComment());
	}
	
	public static void insertInfo() throws SQLException {
		 PreferenceComment preferenceComment = new PreferenceComment();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_comment: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 preferenceComment.setCommentId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 preferenceComment.setUserId(scanUpdate.nextInt());
			 System.out.print(controller.insertPreferenceComment(preferenceComment));	
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			 System.out.print("id_comment: ");
			 Scanner scan = new Scanner(System.in);
			 int commentId = scan.nextInt();
			 System.out.print(controller.deletePreferenceComment(commentId));	
	  
	}
	
	public static void updateInfo() throws SQLException {
		 PreferenceComment preferenceComment = new PreferenceComment();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_comment: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 preferenceComment.setCommentId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_user: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 preferenceComment.setUserId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scan = new Scanner(System.in);
			 int commentId = scan.nextInt();
			 System.out.print(controller.updatePreferenceComment(preferenceComment,commentId));	
			
		 }
	}
}
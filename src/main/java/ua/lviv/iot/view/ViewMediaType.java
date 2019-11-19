package ua.lviv.iot.view;

import java.sql.SQLException;
import java.util.Scanner;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.MediaType;

public class ViewMediaType {
	
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
	     System.out.print(controller.findAllMediaType());
	}
	
	public static void insertInfo() throws SQLException {
		MediaType mediaType = new MediaType();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_media_type: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 mediaType.setMediaTypeId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("media_type: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 mediaType.setMediaType(scanUpdate.next());
			 System.out.print(controller.insertMediaType(mediaType));	
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			System.out.print("id_media_type: ");
	        Scanner scanDelete = new Scanner(System.in);
		    int idMediaType = scanDelete.nextInt();
            System.out.print(controller.deleteMediaType(idMediaType));	
	}
	
	public static void updateInfo() throws SQLException {
		MediaType mediaType = new MediaType();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_media_type: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 mediaType.setMediaTypeId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("media_type: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 mediaType.setMediaType(scanUpdate.next());
		 }
		 if(true) {
			 System.out.print("id_media_type: ");
		     Scanner scanDelete = new Scanner(System.in);
			 int idMediaType = scanDelete.nextInt();
			 System.out.print(controller.updateMediaType(mediaType,idMediaType));	
		 }
	}
}
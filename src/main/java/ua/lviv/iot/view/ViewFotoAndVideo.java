package ua.lviv.iot.view;

import java.sql.SQLException;
import java.util.Scanner;
import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.model.FotoAndVideo;

public class ViewFotoAndVideo {
	
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
	     System.out.print(controller.findAllFotoAndVideo());
	}
	
	public static void insertInfo() throws SQLException {
		 FotoAndVideo fotoAndVideo = new FotoAndVideo();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_foto_or_video: ");
			 Scanner scanInsert = new Scanner(System.in);
			 fotoAndVideo.setIdFotoOrVideo(scanInsert.nextInt());
		 }
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanInsert = new Scanner(System.in);
			 fotoAndVideo.setPostId(scanInsert.nextInt());
		 }
		 if(true) {
			 System.out.print("id_media_type: ");
			 Scanner scanInsert = new Scanner(System.in);
			 fotoAndVideo.setMediaTypeId(scanInsert.nextInt());
		 }
		 if(true) {
			 System.out.print("format: ");
			 Scanner scanInsert = new Scanner(System.in);
			 fotoAndVideo.setFormat(scanInsert.next());
		 }
		 if(true) {
			 System.out.print("url: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 fotoAndVideo.setUrl(scanUpdate.next());
		     System.out.print(controller.insertFotoAndVideo(fotoAndVideo));
		 }
	}
	
	public static void deleteInfo() throws SQLException {
			 System.out.print("id_foto_or_video: ");
			 Scanner scanUpdate = new Scanner(System.in);
		     int idFotoOrVideo = scanUpdate.nextInt(); 
		     System.out.print(controller.deleteFotoAndVideo(idFotoOrVideo));
	}
	
	public static void updateInfo() throws SQLException {
		FotoAndVideo fotoAndVideo = new FotoAndVideo();
		 System.out.print("Ведіть дані: ");
		 if(true) {
			 System.out.print("id_foto_or_video: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 fotoAndVideo.setIdFotoOrVideo(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_post: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 fotoAndVideo.setPostId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("id_media_type: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 fotoAndVideo.setMediaTypeId(scanUpdate.nextInt());
		 }
		 if(true) {
			 System.out.print("format: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 fotoAndVideo.setFormat(scanUpdate.next());
		 }
		 if(true) {
			 System.out.print("url: ");
			 Scanner scanUpdate = new Scanner(System.in);
			 fotoAndVideo.setUrl(scanUpdate.next());
		 }
		 if(true) {
			 System.out.print("id_foto_or_video: ");
			 Scanner scanUpdate = new Scanner(System.in);
		     int idFotoOrVideo = scanUpdate.nextInt();
		     System.out.print(controller.updateFotoAndVideo(fotoAndVideo,idFotoOrVideo));
	      }
		 }
	}
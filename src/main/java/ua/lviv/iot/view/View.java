package ua.lviv.iot.view;

import java.sql.SQLException;
import java.util.Scanner;

public class View {
  
	public static void showInfo() throws SQLException {
		System.out.print("\n" + "Ведіть назву таблицю: ");
		Scanner scan = new Scanner(System.in);
		String table = scan.next();
			switch (table) {
			case "blacklist":
				ViewBlackList.Controler();
				break;
			case "comment":
				ViewComment.Controler();
				break;
			case "fotoandvideo":
				ViewFotoAndVideo.Controler();
				break;
			case "mediatype":
				ViewMediaType.Controler();
				break;
			case "post":
				ViewPost.Controler();
				break;
			case "preference":
				ViewPreference.Controler();
				break;
			case "preference_comment":
				ViewPreferenceComment.Controler();
				break;
			case "tag":
				ViewTag.Controler();
				break;
			case "type_post":
				ViewTypePost.Controler();
				break;
			case "user":
				ViewUser.Controler();
				break;
			case "user_log":
				ViewUserLog.Controler();
				break;
			case "user_security":
				ViewUserSecurity.Controler();
				break;
			default:
				System.out.print("Таблицю " + table + "не найдена. Перевірте правильність ведених даних");
				showInfo();
				break;
			}
	}
}
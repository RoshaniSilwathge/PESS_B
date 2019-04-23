package lk.ac.cmb.ucsc.pess.utils;

public class EmailUtils {
	public static String getUserAccountNotificationEmailBody(String name, String username, String password) {
		return "<div style='width: 510px;background-color: #fff;'>"
				+ "<center style='background-color: #20202f; color: #fff; padding: 10px; font-size: 20px;font-weight: bold;'>"
				+ "<h3>PESS</h3>" + "</center>" +

				"<div style='padding: 20px;'>" + "<center>"
				+ "<div style='font-size: 20px; font-weight: bold; margin-bottom: 14px;'>" + "Hi " + name + "</div>" +

				"<div style='font-size: 15px; margin-bottom: 14px; line-height: 1.6;'>"
				+ "We have created a user account for you with following credentials." + "</div>" +

				"<table style='margin-top: 14px;'>" + "<tr>"
				+ "<td style='width: 140px;background-color: #ccc;padding: 5px;font-weight: bold; text-align: center;'>Username</td>"
				+ "<td style='width: 140px;background-color: #7bd634;padding: 5px;font-weight: bold; text-align: center;'>"
				+ username + "</td>" + "</tr>" + "<tr></tr>" + "<tr>"
				+ "<td style='width: 140px;background-color: #ccc;padding: 5px;font-weight: bold; text-align: center;'>Password</td>"
				+ "<td style='width: 140px;background-color: #7bd634;padding: 5px;font-weight: bold; text-align: center;'>"
				+ password + "</td>" + "</tr>" + "</table>" + "<br>" + "<div style='font-size: 15px;'>"
				+ "Please reset these password once you logged in." + "</div>" + "</center>"
				+ "<hr style='margin-top: 14px; margin-bottom: 14px;'>" + "</div>";
	}
}

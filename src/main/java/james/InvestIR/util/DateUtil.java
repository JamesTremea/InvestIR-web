package james.InvestIR.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * created by james on 09/06/2017
*/

public class DateUtil {

	public static int getAge(Date dateOfBirth) {
		Calendar dob = new GregorianCalendar();
		dob.setTime(dateOfBirth);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		dob.add(Calendar.YEAR, age);
		if (today.before(dob)) {
			age--;
		}
		return age;
	}


	public static Date getToday() {
		Calendar today = Calendar.getInstance();
		Date date = new Date();
		date = (today.getTime());
		return date;
	}

	public static Date formatterDateString(String dateText) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String divi [] = dateText.split("/");

		String dateT = divi[2] + "-" + divi[1] + "-" + divi[0];

		Date date = null;

		try{
			date =  formatter.parse(dateT.trim());
		} catch (Exception e) {

		}

		return date;

	}

	public static Date parseStringToDate(String dateText) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;

		try{
			date =  formatter.parse(dateText.trim());
		} catch (Exception e) {

		}

		return date;
	}

}

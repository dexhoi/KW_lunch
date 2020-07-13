package model;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class ShopChecker {

	public static boolean isAvailable(String name, String priceStr, String genreStr, String timeStr, String[] vacationStr,
			String addressStr, String scoreStr) {

		if(addressStr == null) {return false;}
		if(name == null) {return false;	}
		if(name.isEmpty()) {return false;}
		//if(vacationStr == null) {return false;}
		if(priceStr == null) {return false;}

		try {
			Integer.parseInt(priceStr);
			Integer.parseInt(scoreStr);

			if(vacationStr != null) {
				for(var vac : vacationStr) {
					Integer.parseInt(vac);
				}
			}

			Integer.parseInt(genreStr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return false;
		}

		if(timeStr == null) {return false;}


		try {
			LocalTime.parse(timeStr);
		}catch(DateTimeParseException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}

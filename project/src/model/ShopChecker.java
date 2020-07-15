package model;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class ShopChecker {

	/**
	 * 引数の値がShopインスタンスを生成できるかチェックする
	 * @param name 店名
	 * @param priceStr 価格帯
	 * @param genreStr ジャンルID
	 * @param timeStr 食べられる時間
	 * @param vacationStr 休暇
	 * @param addressStr 住所
	 * @param scoreStr 評価
	 * @return
	 */
	public static boolean isAvailable(String name, String priceStr, String genreStr, String timeStr, String[] vacationStr,
			String addressStr, String scoreStr) {

		if(addressStr == null) {return false;}
		if(name == null) {return false;	}
		if(name.isEmpty()) {return false;}
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

package creckett.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author ArunkumarDhanraj
 *
 */
public class HelperFunctions {

//	new method valid url

	public static boolean validURL(String URL) {

		String regex = "\\bhttps://\\S+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(URL);

		return matcher.matches();

	}

}

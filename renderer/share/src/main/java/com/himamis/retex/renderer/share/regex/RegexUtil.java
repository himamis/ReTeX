package com.himamis.retex.renderer.share.regex;

public class RegexUtil {

	public static String quoteReplacement(String s) {
		if ((s.indexOf('\\') == -1) && (s.indexOf('$') == -1))
			return s;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '\\' || c == '$') {
				sb.append('\\');
			}
			sb.append(c);
		}
		return sb.toString();
	}

}

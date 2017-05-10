package streaming.mosaic;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge {	

	/**
	 * @param url
	 * @return: json string of url parameters
	 */
	public static String Url2Json(String url)  {
		URL uri = null;
		try {
			uri = new URL(url);
		} catch (MalformedURLException e1) {
			return null;
		}
		String query = uri.getQuery();
		if (query == null) {
			return null;
		}
		Map<String, List<String>> args = new HashMap<String, List<String>>();
		for (String pair : query.split("&")) {
			int idx = pair.indexOf("=");
			String name, value;
			try {
				name = URLDecoder.decode(pair.substring(0, idx), "UTF-8");
				value = URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return null;
			}
			List<String> val = args.get(name);
			if (val == null) {
				val = new ArrayList<String>();
				args.put(name, val);
			}
			val.add(value);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		boolean firstArg = true;
		for (Map.Entry<String, List<String>> arg : args.entrySet()) {
			if (firstArg) firstArg = false; else sb.append(", ");
			sb.append("\"").append(arg.getKey()).append("\":");
			List<String> v = arg.getValue();
			if (v.size() == 1) {
				sb.append("\"").append(v.get(0)).append("\"");
			} else {
				sb.append("[");
				boolean firstValue = true;
				for (String s : v) {
					if (firstValue) firstValue = false; else sb.append(", ");
					sb.append("\"").append(s).append("\"");
				}
				sb.append("]");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	
	/**
	 * @param s1: string
	 * @param s2: string
	 * @return true: if s1 is a permutation of s2, false: otherwise
	 */
	public static boolean isPermutation(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		int[] letters = new int[256];
		for (int i=0; i<s1.length(); i++) {
			++letters[(int)s1.charAt(i)];
		}
		for (int i=0; i<s2.length(); i++) {
			if (--letters[(int)s2.charAt(i)] <0) {
				return false;
			}
		}
		for (int i=0; i<256; i++) { 
			if (letters[i] > 0) {
				return false;
			}
		}
		return true;
	}

}

package kr.or.connect.bookserver.util;

public class Base62 {
	  public static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

	  public static String base62(long value) {
	    final StringBuilder sb = new StringBuilder(1);
	    do {
	      sb.insert(0, BASE62[(int) value % 62]);
	      value /= 62;
	    } while (value > 0);
	    return sb.toString();
	  }
	  
	  public static long base62(String value) {
	    long result = 0;
	    long power = 1;
	    for (int i = value.length() - 1; i >= 0; i--) {
	      int digit = value.charAt(i) - 48;
	      if (digit > 42) {
	        digit -= 13;
	      } else if (digit > 9) {
	        digit -= 7;
	      }
	      result += digit * power;
	      power *= 62;
	    }
	    return result;
	  }
}

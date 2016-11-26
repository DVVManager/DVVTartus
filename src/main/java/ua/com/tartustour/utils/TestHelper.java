package ua.com.tartustour.utils;

/**
 * Created by Administrator on 11/6/2016.
 */
public class TestHelper {

     public static String convertToUtf8(String input){
        String result = null;
        try {
            result = new String(input.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return result;
    }

}

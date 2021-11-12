package cora.util;

public class StringUtil {
    public static String lowerCase(String str){
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }

    public static String upperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}

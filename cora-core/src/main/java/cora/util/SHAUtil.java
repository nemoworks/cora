package cora.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHAUtil {
    public static String getStringSHA256(String input){
        return DigestUtils.sha256Hex(input);
    }
}

package com.blog.utils;

import java.util.Map;
import static com.blog.utils.JavaWebToken.verifyJavaWebToken;



public class AuthUtil {


    /**
     * session解密
     */
    public static Map<String, Object> decodeSession(String sessionId) {
        try {
            return verifyJavaWebToken(sessionId);
        } catch (Exception e) {
            System.err.println("");
            return null;
        }
    }
}

package com.wang.ssmtest.utils;

import java.util.Base64;

public class PasswordUtils {
    private final static byte[] ENCRYPT_VAL = ConstUtils.DEFAULT.getBytes();

    /**
     * 加密
     *
     * @param str
     * @return
     */
    public static String encrypt(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ ENCRYPT_VAL[i % ENCRYPT_VAL.length]);
        }
        return new String(Base64.getEncoder().encode(bytes));
    }
    /**
     * 解密
     *
     * @param str
     * @return
     */
    public static String dencrypt(String str) {
        byte[] bytes = Base64.getDecoder().decode(str);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ ENCRYPT_VAL[i % ENCRYPT_VAL.length]);
        }
        return new String(bytes);
    }

}

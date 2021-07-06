package com.gilbarco.utils;

/**
 * @author Tao.Wang
 * @version V1.0
 * @date 2021-07-02 11:46
 */
public class PrintUtils {
    public static void ArrayByteToString(byte[] buff, int len) {
        String context = "{";
        for (int i = 0; i < len; i++) {
            String hex;
            hex = Integer.toHexString(buff[i]);
            if (hex.length() == 1) {
                hex = "0" + hex;
            } else if (hex.length() != 2) {
                hex = hex.substring(6);
            }
            context += ("(byte)0x" + hex + ",");
        }
        context += "}";
        System.out.println(context);
    }
}

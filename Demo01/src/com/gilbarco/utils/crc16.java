package com.gilbarco.utils;

/**
 * @author Tao.Wang
 * @version V1.0
 * @date 2021-07-02 10:34
 */
public class crc16 {

    public static int CRC16_CCITT(byte[] buffer , int len) {
        int wCRCin = 0x0000;
        int wCPoly = 0xa001;
        for (int i = 1 ; i < len ; i++) {
            // System.out.println(Integer.toHexString(buffer[i]));
            wCRCin ^= ((int) buffer[i] & 0x00ff);
            for (int j = 0; j < 8; j++) {
                if ((wCRCin & 0x0001) != 0) {
                    wCRCin >>= 1;
                    wCRCin ^= wCPoly;
                } else {
                    wCRCin >>= 1;
                }
            }
        }
        return wCRCin ^= 0x0000;
    }

    public static int byteArrayToInt(byte[] bytes) {
        int value = 0;
        for (int i = 0; i < 2; i++) {
            int shift = (1 - i) * 8;
            value += ((bytes[i] & 0xFF) << shift);
        }
        return value;
    }

    public static void copy(byte[] des , byte[] src , int srcindex ,int len , int desindex)
    {
        for (int i = 0; i < len; i++) {
            des[desindex + i] = src[srcindex+i];
        }
    }

    public static void IntToCBCD(byte[] pcbcd , int index , int len , int value){
        do{
            pcbcd[index+len-1] = (byte) (value%10);
            value /= 10;
            pcbcd[index+len-1] |= ((value%10)<<4);
            value /= 10;
            len--;
        }while (len > 0 );
    }

    public static  int IntCrcToByte(byte[] src , int index , int value) {
        src[index++] = (byte)((value >> 8) & 0xFF);
        src[index++] = (byte)(value & 0xFF);
        return index++;
    }
}

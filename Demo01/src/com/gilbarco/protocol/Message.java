package com.gilbarco.protocol;

import com.gilbarco.utils.crc16;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * @author Tao.Wang
 * @version V1.0
 * @date 2021-07-02 10:37
 */
public class Message implements Serializable {
     private String data;
     private String test;
    public Message(String data) {
        this.data = data;
    }

    public int encodeing(byte[] src , byte controller) throws UnsupportedEncodingException {
        int len = 0;

        src[len++] = (byte) 0xfd;
        src[len++] = (byte) 0x00;
        src[len++] = (byte) 0x01;
        len += 2;
        src[len++] = controller;
        crc16.copy(src , data.getBytes("GBK"),0 , data.getBytes("GBK").length , len);
        len += data.getBytes("GBK").length;
        crc16.IntToCBCD(src , 3 , 2 , data.getBytes("GBK").length+1);
        int ccitt = crc16.CRC16_CCITT(src, len);
        len = crc16.IntCrcToByte(src, len, ccitt);

        return len;
    }
}

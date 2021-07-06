package com.gilbarco;

import com.alibaba.fastjson.JSON;
import com.gilbarco.pojo.DisplayInfo;
import com.gilbarco.pojo.SpeakInfo;
import com.gilbarco.protocol.Message;
import com.gilbarco.serial.TaoSerial;
import com.gilbarco.utils.PrintUtils;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * @author Tao.Wang
 * @version V1.0
 * @date 2021-07-02 11:33
 */
public class controller {
    public static TaoSerial Serialinstance = TaoSerial.getInstance();
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        Serialinstance.setBaudRate(115200);
        Scanner scanner = new Scanner(System.in);
        System.out.println(Serialinstance.toStringbySerialPortInfo());
        if (Serialinstance.OpenSerial()){
            while (true){
                System.out.println("请机型：" );
                int iteam = scanner.nextInt();
                switch (iteam){
                    case 11:
                        sendmessage(1,1);
                        break;
                    case 12:
                        sendmessage(1 ,2);
                        break;
                    case 22:
                        sendmessage(2 ,2);
                        break;
                    case 14:
                        sendmessage(1 ,4);
                        break;
                    case 24:
                        sendmessage(2 ,4);
                        break;
                    case 34:
                        sendmessage(3 ,4);
                        break;
                    case 44:
                        sendmessage(4 ,4);
                        break;
                    case 16:
                        sendmessage(1 ,6);
                        break;
                    case 26:
                        sendmessage(2 ,6);
                        break;
                    case 36:
                        sendmessage(3 ,6);
                        break;
                    case 46:
                        sendmessage(4 ,6);
                        break;
                    case 56:
                        sendmessage(5 ,6);
                        break;
                    case 66:
                        sendmessage(6 ,6);
                        break;
                    case 18:
                        sendmessage(1 ,8);
                        break;
                    case 28:
                        sendmessage(2 ,8);
                        break;
                    case 38:
                        sendmessage(3 ,8);
                        break;
                    case 48:
                        sendmessage(4 ,8);
                        break;
                    case 58:
                        sendmessage(5 ,8);
                        break;
                    case 68:
                        sendmessage(6 ,8);
                        break;
                    case 78:
                        sendmessage(7 ,8);
                        break;
                    case 88:
                        sendmessage(8 ,8);
                        break;
                    default:
                        break;
                }
            }
        }
        else{
            System.err.println("串口打开失败");
        }
    }
    public static void sendmessage(int pumpid , int pumpnumber) throws UnsupportedEncodingException, InterruptedException {
        String nozzleUp = JSON.toJSONString(new DisplayInfo(pumpid, pumpnumber, "NozzleUp"));
        Message message = new Message(nozzleUp);
        byte[] src = new byte[1024];
        int len = message.encodeing(src, (byte) 0x02);
        Serialinstance.writeBytes(src,len);
        System.out.println(nozzleUp);
        PrintUtils.ArrayByteToString(src , len);
        String displayFuelling = JSON.toJSONString(new DisplayInfo(pumpid, pumpnumber, "DisplayFuelling" , "90#"));
        System.out.println(displayFuelling);
        message = new Message(displayFuelling);
        len = message.encodeing(src, (byte) 0x02);
        Serialinstance.writeBytes(src,len);
        PrintUtils.ArrayByteToString(src , len);

        Thread.sleep(1000*20L);

        String speakup = JSON.toJSONString(new SpeakInfo("Started"));
        System.out.println(speakup);
        message = new Message(speakup);
        len = message.encodeing(src, (byte) 0x06);
        Serialinstance.writeBytes(src,len);
        PrintUtils.ArrayByteToString(src , len);

        Thread.sleep(1000*60L);


        String speakdown = JSON.toJSONString(new SpeakInfo("Ended"));
        System.out.println(speakdown);
        message = new Message(speakdown);
        len = message.encodeing(src, (byte) 0x06);
        Serialinstance.writeBytes(src,len);
        PrintUtils.ArrayByteToString(src , len);

        Thread.sleep(1000*20L);

        String displayTransaction = JSON.toJSONString(new DisplayInfo(pumpid, pumpnumber, "DisplayTransaction"));
        message = new Message(displayTransaction);
        len = message.encodeing(src, (byte) 0x02);
        Serialinstance.writeBytes(src,len);
        System.out.println(displayTransaction);
        PrintUtils.ArrayByteToString(src , len);
    }
}

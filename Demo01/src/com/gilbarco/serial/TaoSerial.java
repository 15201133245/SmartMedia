package com.gilbarco.serial;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;

import java.io.IOException;

/**
 * @author Tao.Wang
 * @version V1.0
 * @date 2020-03-10 11:22
 */
public class TaoSerial {
    private SerialPort[] serialPortList;
    static public TaoSerial taoSerial = null;
    private SerialPort serialPort = null;

    /**
     * 构造函数
     */
    private TaoSerial() {
        serialPortList = SerialPort.getCommPorts();
        if (serialPortList.length != 0) {
            serialPort = serialPortList[0];
        }
    }

    /**
     * @return TaoSerial
     */
    static public final TaoSerial getInstance() {
        if (taoSerial == null) {
            taoSerial = new TaoSerial();
        }
        return taoSerial;
    }

    /**
     * 打开串口
     *
     * @return true:Sucessful    false:Fail
     */
    public boolean OpenSerial() {
        if (serialPort != null) {
            if (!(serialPort.isOpen())) {
                return serialPort.openPort(10);
            }
            return false;
        }
        return false;
    }

    /**
     * 关闭串口
     *
     * @return true:Sucessful    false:Fail
     */
    public boolean CloseSerial() {
        if (serialPort != null) {
            if (serialPort.isOpen()) {
                return serialPort.closePort();
            }
            return false;
        }
        return false;
    }

    /**
     * 读取数据
     *
     * @param buffer      数据
     * @param bytesToRead 长度
     * @return 0 or -1 失败
     */
    public int readBytes(byte[] buffer, int bytesToRead) {
        if (serialPort != null) {
            if (serialPort.isOpen()) {
                try {
                    return serialPort.getInputStream().read(buffer, 0, bytesToRead);
                } catch (IOException e) {
                    //System.err.println(e.toString());
                    return -1;
                }
            }
            return -1;
        }
        return -1;
    }

    /**
     * 写入数据
     *
     * @param buffer       数据
     * @param bytesToWrite 长度
     * @return 0 or -1 失败
     */
    public int writeBytes(byte[] buffer, int bytesToWrite) {
        if (serialPort != null) {
            if (serialPort.isOpen()) {
                try {
                    serialPort.getOutputStream().write(buffer, 0, bytesToWrite);
                    return bytesToWrite;
                } catch (IOException e) {
                    e.printStackTrace();
                    return -1;
                }
            }
            return -1;
        }
        return -1;
    }

    public final boolean addDataListener(SerialPortDataListener listener) {
        if (serialPort != null) {
            return serialPort.addDataListener(listener);
        } else {
            return false;
        }
    }

    /**
     * 串口信息
     *
     * @return SerialPortInfo
     */
    public String toStringbySerialPortInfo() {
        if (serialPort != null) {
            return "串口号:" + serialPort.getSystemPortName() + "\n波特率:" + serialPort.getBaudRate();
        }
        return "";
    }

    public void setBaudRate(int i) {
        if (serialPort != null)
            serialPort.setBaudRate(i);
    }
}

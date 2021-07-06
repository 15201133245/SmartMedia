package com.gilbarco.pojo;

import java.io.Serializable;

/**
 *  * @ File    : com.gilbarco.smartmedia.pojo
 *  * @ author  : Tao.Wang
 *  * @ Time    : 2021-06-29--14:52
 *  * @ Version : 1.0
 * * @ Des     : ${TODO}
 */
public class DisplayInfo implements Serializable{
    private Integer PumpId;
    private Integer PumpNumber;
    private Integer Duration;
    private String  WinId;
    private String Balance;
    private String Amount;
    private String Volume;
    private String Discount;
    private String Gradename;

    public DisplayInfo() {
    }

    public DisplayInfo(Integer pumpId, Integer pumpNumber, String winId) {
        PumpId = pumpId;
        PumpNumber = pumpNumber;
        WinId = winId;
    }

    public DisplayInfo(Integer pumpId, Integer pumpNumber, String winId, String gradename) {
        PumpId = pumpId;
        PumpNumber = pumpNumber;
        WinId = winId;
        Gradename = gradename;
    }

    public DisplayInfo(Integer pumpId, Integer pumpNumber, Integer duration, String winId, String balance, String amount, String volume, String discount, String gradename) {
        PumpId = pumpId;
        PumpNumber = pumpNumber;
        Duration = duration;
        WinId = winId;
        Balance = balance;
        Amount = amount;
        Volume = volume;
        Discount = discount;
        Gradename = gradename;
    }

    public Integer getPumpId() {
        return PumpId;
    }

    public void setPumpId(Integer pumpId) {
        PumpId = pumpId;
    }

    public Integer getPumpNumber() {
        return PumpNumber;
    }

    public void setPumpNumber(Integer pumpNumber) {
        PumpNumber = pumpNumber;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer duration) {
        Duration = duration;
    }

    public String getWinId() {
        return WinId;
    }

    public void setWinId(String winId) {
        WinId = winId;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getVolume() {
        return Volume;
    }

    public void setVolume(String volume) {
        Volume = volume;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getGradename() {
        return Gradename;
    }

    public void setGradename(String gradename) {
        Gradename = gradename;
    }

    @Override
    public String toString() {
        return "DisplayInfo{" +
                "PumpId=" + PumpId +
                ", PumpNumber=" + PumpNumber +
                ", Duration=" + Duration +
                ", WinId='" + WinId + '\'' +
                ", Balance='" + Balance + '\'' +
                ", Amount='" + Amount + '\'' +
                ", Volume='" + Volume + '\'' +
                ", Discount='" + Discount + '\'' +
                ", Gradename='" + Gradename + '\'' +
                '}';
    }
}
